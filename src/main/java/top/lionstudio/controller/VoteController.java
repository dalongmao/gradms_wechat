package top.lionstudio.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;

import top.lionstudio.entity.VoteGroup;
import top.lionstudio.entity.VoteInfo;
import top.lionstudio.entity.VoteItem;
import top.lionstudio.entity.WechatUser;
import top.lionstudio.repo.VoteGroupRepo;
import top.lionstudio.repo.VoteInfoRepo;
import top.lionstudio.repo.VoteItemRepo;
import top.lionstudio.tool.DateTimeTool;
import top.lionstudio.tool.JsonTool;
import top.lionstudio.tool.MapTool;

@RestController
public class VoteController {
	@Autowired
	private VoteInfoRepo voteInfoRepo;
	@Autowired
	private VoteItemRepo voteItemRepo;
	@Autowired
	private VoteGroupRepo voteGroupRepo;

	// 得到一组表决
	@RequestMapping(value = "/vote/getGroupVote", method = RequestMethod.POST)
	public @ResponseBody Object getGroupVote(@RequestBody Map<String, Object> map,
			@SessionAttribute("USER") WechatUser user) {
		int id_user = user.getUserid();

		int id = Integer.parseInt(map.get("id") + "");
		VoteGroup voteGroup = voteGroupRepo.findById(id);
		if (voteGroup.getTimeEnd().before(new Date()))
			return MapTool.getErrorRes("会议表决已截止");

		List<Map<String, Object>> listVote = new ArrayList<>();
		for (VoteInfo item : voteInfoRepo.findByIdGroup(id)) {
			Map<String, Object> itemMap = new HashMap<>();
			itemMap.put("title", item.getTitle());
			itemMap.put("id", item.getId());
			itemMap.put("type", item.getType());

			VoteItem voteItem = voteItemRepo.findByIdUserAndIdVote(id_user, item.getId());
			if (voteItem == null) {
				voteItem = new VoteItem();
				voteItem.setIdUser(id_user);
				voteItem.setIdVote(item.getId());
				voteItem.setNum_submit(0);
				voteItemRepo.save(voteItem);
			}
			if (voteItem.getNum_submit() > 0)
				itemMap.put("status", 1);
			else
				itemMap.put("status", 0);

			listVote.add(itemMap);

		}
		Map<String, Object> result = MapTool.Obj2Map(voteGroup);
		result.put("votelist", listVote);
		result.put("timeEnd", DateTimeTool.getFormatDate(voteGroup.getTimeEnd(), DateTimeTool.DataFormat3));
		return MapTool.getSuccessRes(result);

	}

	@RequestMapping(value = "/vote/getVoteById", method = RequestMethod.POST)
	public @ResponseBody Object getVoteById(@RequestBody Map<String, Object> map,
			@SessionAttribute("USER") WechatUser user) {
		int id_user = user.getUserid();
		int id = Integer.parseInt(map.get("id") + "");
		if (voteInfoRepo == null)
			System.out.println("null");

		VoteInfo voteInfo = voteInfoRepo.findById(id);

		Map<String, Object> result = MapTool.Obj2Map(voteInfo);
		result.put("timedur", DateTimeTool.getFormatDate(voteInfo.getTimeCreat(), DateTimeTool.DataFormat8) + "-"
				+ DateTimeTool.getFormatDate(voteInfo.getTimeEnd(), DateTimeTool.DataFormat8));

		VoteItem voteItem = voteItemRepo.findByIdUserAndIdVote(id_user, id);

		
		if(voteInfo.getType().equals("single")) {
			result.put("result", voteItem.getResult());
			return MapTool.getSuccessRes(result);}
		List<Map> Jsoncontent = (List) JsonTool.fromJson(voteInfo.getContent(), List.class);
		List<Map> Jsonresult = (List) JsonTool.fromJson(voteItem.getResult(), List.class);

		for (Map item : Jsoncontent) {
			int index = 0;

			if (item.get("index") instanceof Double)
				index = ((Double) item.get("index")).intValue();
			else
				index = Integer.parseInt(item.get("index") + "");
			Map resultOb = null;
			if (Jsonresult != null && Jsonresult.size() > 0)
				for (Map resultItem : Jsonresult) {
					int resultIndex = 0;
					if (resultItem.get("index") instanceof Double)
						resultIndex = ((Double) resultItem.get("index")).intValue();
					else
						resultIndex = Integer.parseInt(resultItem.get("index") + "");

					if (index == resultIndex) {
						resultOb = resultItem;
						break;
					}
				}

			item.put("status", resultOb.get("status"));
		}
		result.put("content", Jsoncontent);

		return MapTool.getSuccessRes(result);
	}

	@RequestMapping(value = "/vote/createVote", method = RequestMethod.POST)
	public @ResponseBody Object createVote(@RequestBody Map<String, Object> map,
			@SessionAttribute("USER") WechatUser user) {
		int id = Integer.parseInt(map.get("id") + "");
		//

		return MapTool.getSuccessRes(id);
	}

	@RequestMapping(value = "/vote/letvote", method = RequestMethod.POST)
	public @ResponseBody Object vote(@RequestBody Map<String, Object> map, @SessionAttribute("USER") WechatUser user) {
		int id_vote = (int) map.get("id");
		int id_user = user.getUserid();
		String result = JsonTool.toJson(map.get("result"));
		VoteItem voteItem = voteItemRepo.findByIdUserAndIdVote(id_user, id_vote);
		voteItem.setResult(result);
		voteItem.setTimeVoteLast(new Date());
		voteItem.setNum_submit(voteItem.getNum_submit() + 1);
		voteItemRepo.save(voteItem);
		return MapTool.getSuccessRes("success");
	}

}
