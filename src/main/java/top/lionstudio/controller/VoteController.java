package top.lionstudio.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VoteController {
	
	@RequestMapping(value = "/vote/getVoteById", method = RequestMethod.POST)
	public @ResponseBody Object getVoteById(@RequestBody Map<String,Object> map, HttpSession httpsession) {
		int id=(int) map.get("id");
		
		
		

		return null;
	}
	@RequestMapping(value = "/vote/createVote", method = RequestMethod.POST)
	public @ResponseBody Object createVote(@RequestBody Map<String,Object> map, HttpSession httpsession) {
		int id=(int) map.get("id");
		
		
		

		return null;
	}
	



}
