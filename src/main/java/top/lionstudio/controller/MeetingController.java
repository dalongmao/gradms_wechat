package top.lionstudio.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import top.lionstudio.entity.MeetingInfo;
import top.lionstudio.entity.MeetingSign;
import top.lionstudio.entity.WechatUser;
import top.lionstudio.repo.MeetinginfoRepo;
import top.lionstudio.repo.SigninfoRepo;
import top.lionstudio.tool.DateTimeTool;
import top.lionstudio.tool.MapTool;

@RestController
public class MeetingController {

	@Autowired
	private SigninfoRepo signinfoRepo;
	@Autowired
	private MeetinginfoRepo meetinginforepo;

	@RequestMapping(value = "/meeting/getmeetinginfo", method = RequestMethod.POST)
	public @ResponseBody Object getmeetinginfo(@RequestBody Map<String, Object> map, HttpSession httpsession) {
		WechatUser user = (WechatUser) httpsession.getAttribute("USER");
		int id = (int) map.get("id");
		MeetingInfo meetinginfo = meetinginforepo.findById(id);

		int pnum = (int) signinfoRepo.count();

		Map<String, Object> form = new HashMap<>();
		form.put("name", meetinginfo.getName());
		form.put("timestart", DateTimeTool.getFormatDate(meetinginfo.getTimeStart(), DateTimeTool.DataFormat8));
		form.put("timeend", DateTimeTool.getFormatDate(meetinginfo.getTimeEnd(), DateTimeTool.HHmm));
		form.put("signupend", DateTimeTool.getFormatDate(meetinginfo.getTimeSignupEnd(), DateTimeTool.DataFormat8));
		form.put("signupstart", DateTimeTool.getFormatDate(meetinginfo.getTimeSignupStart(), DateTimeTool.DataFormat8));
		form.put("address", meetinginfo.getAddress());
		form.put("maxnum", meetinginfo.getMaxnum());
		form.put("descri", meetinginfo.getDescri());
		form.put("pnum", pnum);
		form.put("hassign", false);

		if (signinfoRepo.findByOpenid(user.getOpenid()) != null) {
			form.put("hassign", true);
		}

		return MapTool.getSuccessRes(form);

	}

	@RequestMapping(value = "/meeting/sign", method = RequestMethod.POST)
	public @ResponseBody Object sign(@RequestBody Map<String, Object> map, HttpSession httpsession) {
		WechatUser user = (WechatUser) httpsession.getAttribute("USER");
		MeetingSign signinfo = signinfoRepo.findByOpenid(user.getOpenid());
		if (signinfo == null)
			signinfo = new MeetingSign();
		String name = (String) map.get("name");
		String num = (String) map.get("num");
		String phonenum = (String) map.get("phonenum");
		String college = (String) map.get("college");
		String type = (String) map.get("type");

		signinfo.setCollege(college);
		signinfo.setOpenid(user.getOpenid());
		signinfo.setNum(num);
		signinfo.setPhonenum(phonenum);
		signinfo.setType(type);
		signinfo.setName(name);
		try {
			signinfoRepo.save(signinfo);
			return MapTool.getSuccessRes(null);
		} catch (Exception e) {
			e.printStackTrace();
			return MapTool.getErrorRes("未知错误");

		}

	}
	
	

	@RequestMapping(value = "/meeting/getsigninfo", method = RequestMethod.POST)
	public @ResponseBody Object getsigninfo(@RequestBody Map<String, Object> map, HttpSession httpsession) {
		WechatUser user = (WechatUser) httpsession.getAttribute("USER");
		MeetingSign signinfo = signinfoRepo.findByOpenid(user.getOpenid());

		return MapTool.getSuccessRes(signinfo);
	}

}
