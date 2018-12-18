package top.lionstudio.controller;


import java.util.Map;



import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import top.lionstudio.service.DoctorService;
import top.lionstudio.tool.MapTool;

@RestController
public class DoctorProclaimController {
	@Autowired
	private DoctorService doctorService;


	@RequestMapping(value = "/doctor/getdoctorproclaim", method = RequestMethod.POST)
	public @ResponseBody Object test(@RequestBody Map<String, Object> map, HttpSession httpsession) {
	//	ZwWechatUser user = (ZwWechatUser) httpsession.getAttribute("USER");
	//	int id = user.getUserid();
		int id=115723;
		return MapTool.getSuccessRes(doctorService.requestDoctorAnswerProclaimForm(id));
	}

}
