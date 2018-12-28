package top.lionstudio.controller;

import java.util.Map;

import javax.persistence.Id;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import top.lionstudio.entity.VoteInfo;
import top.lionstudio.repo.VoteInfoRepo;
import top.lionstudio.tool.MapTool;


@RestController
public class VoteController {
	@Autowired
	private VoteInfoRepo voteInfoRepo;
	
	@RequestMapping(value = "/vote/getVoteById", method = RequestMethod.POST)
	public @ResponseBody Object getVoteById(@RequestBody Map<String,Object> map, HttpSession httpsession) {
		int id=(int) map.get("id");
		VoteInfo voteInfo=voteInfoRepo.findById(id);

		return MapTool.getSuccessRes(voteInfo);
	}
	@RequestMapping(value = "/vote/createVote", method = RequestMethod.POST)
	public @ResponseBody Object createVote(@RequestBody Map<String,Object> map, HttpSession httpsession) {
		int id=(int) map.get("id");
		
		
		

		return null;
	}
	



}
