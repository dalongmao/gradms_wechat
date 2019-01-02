package top.lionstudio.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import top.lionstudio.entity.VoteGroup;
import top.lionstudio.entity.VoteInfo;
import top.lionstudio.entity.VoteItem;
import top.lionstudio.entity.WechatUser;
import top.lionstudio.repo.VoteGroupRepo;
import top.lionstudio.repo.VoteInfoRepo;
import top.lionstudio.repo.VoteItemRepo;
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
	public @ResponseBody Object getGroupVote(@RequestBody Map<String,Object> map, HttpSession httpsession) {
		int id=Integer.parseInt(map.get("id")+"");
		VoteGroup voteGroup=voteGroupRepo.findById(id);
		if(voteGroup.getTimeEnd().before(new Date()))
			return MapTool.getErrorRes("会议表决已截止");
		List<VoteInfo> listVote=voteInfoRepo.findByIdGroup(id);
		Map<String,Object> result=MapTool.Obj2Map(voteGroup);
		result.put("votelist", listVote);
		return MapTool.getSuccessRes(result);
		
	}
	@RequestMapping(value = "/vote/getVoteById", method = RequestMethod.POST)
	public @ResponseBody Object getVoteById(@RequestBody Map<String,Object> map, HttpSession httpsession) {
		int id=Integer.parseInt(map.get("id")+"");
		if(voteInfoRepo==null)
			System.out.println("null");
		VoteInfo voteInfo=voteInfoRepo.findById(id);
		return MapTool.getSuccessRes(voteInfo);
	}
	@RequestMapping(value = "/vote/createVote", method = RequestMethod.POST)
	public @ResponseBody Object createVote(@RequestBody Map<String,Object> map, HttpSession httpsession) {
		int id=Integer.parseInt(map.get("id")+"") ;
		
		return MapTool.getSuccessRes(id);
	}
	@RequestMapping(value="/vote/vote",method = RequestMethod.POST)
	public @ResponseBody Object vote(@RequestBody Map<String,Object> map, HttpSession httpsession) {
		WechatUser user=(WechatUser) httpsession.getAttribute("USER");
		int id=(int) map.get("id");
		String result=(String) map.get("result");
		int id_user=user.getUserid();
	
	
		VoteItem voteItem=new VoteItem();
		voteItem.setIdUser(id_user);
		voteItem.setIdVote(id);
		voteItem.setResult(result);
		voteItem.setTimeVote(new Date());
		voteItemRepo.save(voteItem);
		
		return MapTool.getSuccessRes("success");
	} 
	



}
