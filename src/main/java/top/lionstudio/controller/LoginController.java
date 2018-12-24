package top.lionstudio.controller;

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

import top.lionstudio.entity.WechatUser;
import top.lionstudio.repo.WechatUserRepo;
import top.lionstudio.service.UserService;
import top.lionstudio.tool.MD5Tool;
import top.lionstudio.tool.MapTool;
import top.lionstudio.tool.StringTool;

@RestController
public class LoginController {
	@Autowired
	private WechatUserRepo wechatUserRepo;
	@Autowired
	private UserService userService;


	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public @ResponseBody Object test(@RequestBody Map<String,Object> map, HttpSession httpsession) {
		System.out.println(new Gson().toJson(map));

		return null;
	}
	

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody Object login(@RequestBody Map<String,Object>  map, HttpSession httpsession) {
		Gson gson = new Gson();
		String code = (String) map.get("code");
		String iv = (String) map.get("iv");
		String encryptedData = (String) map.get("encryptedData");
		JsonObject logininfo = gson.fromJson(userService.getUserInfo(code), JsonObject.class);
		String openid = logininfo.get("openid").getAsString();
		String session_key = logininfo.get("session_key").getAsString();
		WechatUser wuser = wechatUserRepo.findByOpenid(openid);
		JsonObject userinfo = gson.fromJson(MD5Tool.decryptUserinfo(encryptedData, session_key, iv), JsonObject.class);
		if (wuser == null) {
			wuser = new WechatUser();
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
	
	

	

}
