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

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import top.lionstudio.entity.ZwMeetingInfo;
import top.lionstudio.entity.ZwMeetingSign;
import top.lionstudio.entity.ZwWechatUser;
import top.lionstudio.repo.MeetinginfoRepo;
import top.lionstudio.repo.SigninfoRepo;
import top.lionstudio.repo.WechatUserRepo;
import top.lionstudio.tool.DateTimeTool;
import top.lionstudio.tool.MD5Tool;
import top.lionstudio.tool.MapTool;
import top.lionstudio.tool.RequestTool;
import top.lionstudio.tool.StringTool;

@RestController
public class LoginController {
	@Autowired
	private WechatUserRepo wechatUserRepo;
	@Autowired
	private SigninfoRepo signinfoRepo;
	@Autowired
	private MeetinginfoRepo meetinginforepo;

	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public @ResponseBody Object test(@RequestBody Map<String,Object> map, HttpSession httpsession) {
		System.out.println(new Gson().toJson(map));

		return null;
	}
	
	@RequestMapping(value = "/getsigninfo", method = RequestMethod.POST)
	public @ResponseBody Object getsigninfo(@RequestBody Map<String,Object>  map, HttpSession httpsession) {
		ZwWechatUser user = (ZwWechatUser) httpsession.getAttribute("USER");
		ZwMeetingSign signinfo= signinfoRepo.findByOpenid(user.getOpenid());
		
		return MapTool.getSuccessRes(signinfo);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody Object login(@RequestBody Map<String,Object>  map, HttpSession httpsession) {
		Gson gson = new Gson();
		String code = (String) map.get("code");
		String iv = (String) map.get("iv");
		String encryptedData = (String) map.get("encryptedData");
		JsonObject logininfo = gson.fromJson(new RequestTool().getUserInfo(code), JsonObject.class);
		String openid = logininfo.get("openid").getAsString();
		String session_key = logininfo.get("session_key").getAsString();
		ZwWechatUser wuser = wechatUserRepo.findByOpenid(openid);
		JsonObject userinfo = gson.fromJson(MD5Tool.decryptUserinfo(encryptedData, session_key, iv), JsonObject.class);
		if (wuser == null) {
			wuser = new ZwWechatUser();
			wuser.setOpenid(openid);
		}
		wuser.setNickname(StringTool.filterEmoji(userinfo.get("nickName").getAsString()));
		wuser.setCity(userinfo.get("city").getAsString());
		wuser.setCountry(userinfo.get("country").getAsString());
		wuser.setProvince(userinfo.get("province").getAsString());
		wuser.setHeadimgurl(userinfo.get("avatarUrl").getAsString());
		wuser.setLanguage(userinfo.get("language").getAsString());
		wuser.setSex(userinfo.get("gender").getAsInt());
		try {
			wechatUserRepo.saveAndFlush(wuser);
		} catch (Exception e) {
			e.printStackTrace();
			return MapTool.getErrorRes("未知错误");
		}
		httpsession.setAttribute("USER", wuser);
		return MapTool.getSuccessRes(wuser);
	}
	
	

	@RequestMapping(value = "/getmeetinginfo", method = RequestMethod.POST)
	public @ResponseBody Object getmeetinginfo(@RequestBody Map<String,Object>  map, HttpSession httpsession) {
		ZwWechatUser user = (ZwWechatUser) httpsession.getAttribute("USER");
		int id = (int) map.get("id");
		ZwMeetingInfo meetinginfo = meetinginforepo.findById(id);
		
		
		int pnum=(int) signinfoRepo.count();

		Map<String,Object> form=new HashMap<>();
		form.put("name", meetinginfo.getName());
		form.put("timestart", DateTimeTool.getFormatDate(meetinginfo.getTimeStart(), DateTimeTool.DataFormat8));
		form.put("timeend", DateTimeTool.getFormatDate(meetinginfo.getTimeEnd(), DateTimeTool.HHmm));
		form.put("signupend", DateTimeTool.getFormatDate(meetinginfo.getTimeSignupEnd(), DateTimeTool.DataFormat8));
		form.put("signupstart",DateTimeTool.getFormatDate(meetinginfo.getTimeSignupStart(), DateTimeTool.DataFormat8));
		form.put("address", meetinginfo.getAddress());
		form.put("maxnum", meetinginfo.getMaxnum());
		form.put("descri", meetinginfo.getDescri());
		form.put("pnum", pnum);
		form.put("hassign", false);
		
		if(signinfoRepo.findByOpenid(user.getOpenid())!=null) {
			form.put("hassign", true);
		}
		
	
		return MapTool.getSuccessRes(form);

	}

	@RequestMapping(value = "/sign", method = RequestMethod.POST)
	public @ResponseBody Object sign(@RequestBody Map<String,Object>  map, HttpSession httpsession) {
		ZwWechatUser user = (ZwWechatUser) httpsession.getAttribute("USER");
		ZwMeetingSign signinfo =signinfoRepo.findByOpenid(user.getOpenid());
		if(signinfo==null)
			 signinfo=new ZwMeetingSign();
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

}
