package top.lionstudio.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import top.lionstudio.entity.RoomApply;
import top.lionstudio.repo.RoomApplyRepo;
import top.lionstudio.repo.RoomInfoRepo;
import top.lionstudio.tool.DateTimeTool;

@RestController
public class RoomController {

	@Autowired
	private RoomApplyRepo roomApplyRepo;
	@Autowired
	private RoomInfoRepo roomInfoRepo;

	@RequestMapping(value = "/wechat/getMyApply", method = RequestMethod.POST)
	public @ResponseBody Object getMyApply(@RequestBody Map map, HttpSession httpsession) {
		String datestr = (String) map.get("date");
		Date date = DateTimeTool.getDateFromAllStr(datestr);
		List<MeetingRoomApplyInfo> list = quickDao.getListPoByNV(MeetingRoomApplyInfo.class, "meetingDate",
				DateTimeTool.changeDate2Today(date), "applyerNum", "201734893");
		return MapTool.getSuccessRes(list);
	}

	@RequestMapping(value = "/wechat/getTodayApply", method = RequestMethod.POST)
	public @ResponseBody Object getTodayApply(@RequestBody Map map, HttpSession httpsession) {
		List<MeetingRoomApplyInfo> list = quickDao.getListPoByNV(MeetingRoomApplyInfo.class, "meetingDate",
				DateTimeTool.changeDate2Today(new Date()));
		return MapTool.getSuccessRes(list);

	}

	@RequestMapping(value = "/wechat/deleteapply", method = RequestMethod.POST)
	public @ResponseBody Object deleteapply(@RequestBody Map map, HttpSession httpsession) {
		int id = (int) map.get("id");
		MeetingRoomApplyInfo meetingRoomApplyInfo=quickDao.getPoById(MeetingRoomApplyInfo.class, id);
		
		System.out.println(new Gson().toJson(meetingRoomApplyInfo));
	
		if (meetingRoomApplyInfoDao.delete(meetingRoomApplyInfo))
			return MapTool.getSuccessRes("取消成功");
		else
			return MapTool.getErrorRes("取消失败");

	}

	// 得到当前季节的排班表
	@RequestMapping(value = "/wechat/getTimeTable", method = RequestMethod.POST)
	public @ResponseBody Object getTimeTable(@RequestBody Map map, HttpSession httpsession) {
		// 换季需要更改TimeTool里的常量SIGN
		String time[] = TimeTool.getTimeTable();
		List<Map<String, String>> resMap = new ArrayList<>();
		for (String string : time) {
			Map<String, String> item = new HashMap<>();
			item.put("s", string.split("~")[0]);
			item.put("e", string.split("~")[1]);
			resMap.add(item);

		}
		return MapTool.getSuccessRes(resMap);
	}

	@RequestMapping(value = "/wechat/getApplyTable", method = RequestMethod.POST)
	public @ResponseBody Object getApplyTable(@RequestBody Map map, HttpSession httpsession) {
		// 返回一个二维表单比较好 但我实在是懒惰
		Date date = DateTimeTool.getDateFromAllStr((String) map.get("date"));
		List<MeetingRoomApplyInfo> list = quickDao.getListPoByNV(MeetingRoomApplyInfo.class, "meetingDate", date);
		List<MeetingRoomInfo> listMeetingRoom = quickDao.getListPoAll(MeetingRoomInfo.class);

		Map<Integer, Map<String, Object>> resMap = new HashMap<>();

		for (MeetingRoomInfo meetingRoomInfo : listMeetingRoom) {
			Map<String, Object> itemMap = new HashMap<>();
			itemMap.put("roomname", meetingRoomInfo.getRoomName());
			itemMap.put("meetinglist", new Map[6]);
			resMap.put(meetingRoomInfo.getRoomId(), itemMap);
		}
		for (MeetingRoomApplyInfo meetingRoomApplyInfo : list) {
			Map<String, Object> itemMap = resMap.get(meetingRoomApplyInfo.getMeetingRoomInfo().getRoomId());

			Map<String, Object> meetinglist[] = (Map<String, Object>[]) itemMap.get("meetinglist");

			Map<String, Object> meetinginfomap = new HashMap<>();

			int start = TimeTool.getIndexByStartTimeString(meetingRoomApplyInfo.getStartTime());
			int end = TimeTool.getIndexByEndTimeString(meetingRoomApplyInfo.getEndTime());
			meetinginfomap.put("applyer", StringTool.replaceBlank(meetingRoomApplyInfo.getApplyerName()));
			meetinginfomap.put("topic", StringTool.replaceBlank(meetingRoomApplyInfo.getTopic().trim()));
			meetinginfomap.put("color", ColorTool.getSuitableColor());
			meetinginfomap.put("length", end - start + 1);
			meetinginfomap.put("status", 1);
			meetinginfomap.put("applyid", meetingRoomApplyInfo.getApplyId());

			meetinglist[start] = meetinginfomap;

			for (int i = start + 1; i <= end; i++) {
				meetinglist[i] = new HashMap<>();
				meetinglist[i].put("status", -1);
			}
		}

		return MapTool.getSuccessRes(resMap);
	}

	@RequestMapping(value = "/wechat/getApplyInfo", method = RequestMethod.POST)
	public @ResponseBody Object getApplyInfo(@RequestBody Map map, HttpSession httpsession) {

		int appid = Integer.parseInt(map.get("applyid") + "");
		MeetingRoomApplyInfo meetingRoomApplyInfo = quickDao.getPoById(MeetingRoomApplyInfo.class, appid);
		return MapTool.getSuccessRes(meetingRoomApplyInfo);
	}

	@RequestMapping(value = "/wechat/getRoomStatus", method = RequestMethod.POST)
	public @ResponseBody Object getRoomStatus(@RequestBody Map map, HttpSession httpsession) {
		Date date = DateTimeTool.getDateFromStr((String) map.get("date"), DateTimeTool.DateFormat1);
		String sql = "from MeetingRoomApplyInfo where meetingDate = ? ";
		Query query = quickDao.querySql(sql);
		query.setParameter(0, date);
		List<MeetingRoomApplyInfo> list = query.list();
		Map<Integer, RoomStatus> roomstatusmap = new HashMap<>();
		for (MeetingRoomInfo roominfo : quickDao.getListPoAll(MeetingRoomInfo.class)) {
			RoomStatus roomStatus = new RoomStatus(roominfo);
			roomstatusmap.put(roominfo.getRoomId(), roomStatus);
		}
		for (MeetingRoomApplyInfo meetingRoomApplyInfo : list) {
			int startindex = TimeTool.getIndexByStartTimeString(meetingRoomApplyInfo.getStartTime());
			int endindex = TimeTool.getIndexByEndTimeString(meetingRoomApplyInfo.getEndTime());

			roomstatusmap.get(meetingRoomApplyInfo.getMeetingRoomInfo().getRoomId()).addOrder(startindex, endindex,
					meetingRoomApplyInfo.getTopic(), meetingRoomApplyInfo.getApplyerName());
		}
		return MapTool.getSuccessRes(roomstatusmap);
	}

	@RequestMapping(value = "/wechat/AddApply", method = RequestMethod.POST)
	public @ResponseBody Object AddApply(@RequestBody Map map, HttpSession httpsession) {
		WechatUser user = (WechatUser) httpsession.getAttribute("USER");
		String topic = (String) map.get("topic");
		List<Integer> roomIdlist = (List<Integer>) map.get("roomIdlist");
		String oname = (String) map.get("oname");
		String brief = (String) map.get("brief");
		String start = ((String) map.get("order")).split("~")[0];
		String end = ((String) map.get("order")).split("~")[1];

		Date date = DateTimeTool.getDateFromStr((String) map.get("date"), DateTimeTool.DateFormat1);

		String applynum = meetingRoomApplyInfoDao
				.getNewApplyNum(DateTimeTool.getFormatDate(new Date(), DateTimeTool.YYYYMMdd));

		MeetingRoomInfo temp = quickDao.getPoById(MeetingRoomInfo.class, roomIdlist.get(0));

		MeetingRoomApplyInfo meetingRoomApplyInfo = new MeetingRoomApplyInfo();
		meetingRoomApplyInfo.setApplyNum(applynum);
		meetingRoomApplyInfo.setMeetingRoomInfo(temp);
		meetingRoomApplyInfo.setMeetingDate(date);
		meetingRoomApplyInfo.setEndTime(end);
		meetingRoomApplyInfo.setStartTime(start);
		meetingRoomApplyInfo.setTopic(topic);
		meetingRoomApplyInfo.setBrief(brief);
		meetingRoomApplyInfo.setOrganizer(oname);
		meetingRoomApplyInfo.setApplyTime(new Date());
		meetingRoomApplyInfo.setApplyerNum("adas");
		meetingRoomApplyInfo.setApplyerName("asdasd");
		meetingRoomApplyInfo.setStatus("1");
		meetingRoomApplyInfo.setModifyTime(new Date());

		quickDao.saveNewPo(meetingRoomApplyInfo);
		return MapTool.getSuccessRes("保存成功");
	}

	@RequestMapping(value = "/wechat/getroomlist", method = RequestMethod.POST)
	public @ResponseBody Object getroomlist(@RequestBody Map map, HttpSession httpsession) {
		return MapTool.getSuccessRes(quickDao.getListPoAll(MeetingRoomInfo.class));
	}


}
