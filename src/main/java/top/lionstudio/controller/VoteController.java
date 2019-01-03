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
	public @ResponseBody Object getGroupVote(@RequestBody Map<String,Object> map, @SessionAttribute("USER") WechatUser user) {
		int id_user=user.getUserid();
		
		
		int id=Integer.parseInt(map.get("id")+"");
		VoteGroup voteGroup=voteGroupRepo.findById(id);
		if(voteGroup.getTimeEnd().before(new Date()))
			return MapTool.getErrorRes("会议表决已截止");
	
		List<Map<String,Object>> listVote=new ArrayList<>();
		for(VoteInfo item:voteInfoRepo.findByIdGroup(id)) {
			Map<String,Object> itemMap=new HashMap<>();
			itemMap.put("title", item.getTitle());
			itemMap.put("id", item.getId());
			itemMap.put("type", item.getType());
			
			VoteItem voteItem=voteItemRepo.findByIdUserAndIdVote(id_user, item.getId());
			if(voteItem==null) {
				voteItem=new VoteItem();
				voteItem.setIdUser(id_user);
				voteItem.setIdVote(item.getId());
				voteItem.setNum_submit(0);
				voteItemRepo.save(voteItem);
			}
			if(voteItem.getNum_submit()>0) 
			   itemMap.put("status", "已完成，可修改");
			else
			   itemMap.put("status", "未完成");
			
			listVote.add(itemMap);
		   
		}
		Map<String,Object> result=MapTool.Obj2Map(voteGroup);
		result.put("votelist", listVote);
		result.put("timeEnd", DateTimeTool.getFormatDate(voteGroup.getTimeEnd(), DateTimeTool.DataFormat3));
		return MapTool.getSuccessRes(result);
		
	}
	@RequestMapping(value = "/vote/getVoteById", method = RequestMethod.POST)
	public @ResponseBody Object getVoteById(@RequestBody Map<String,Object> map,@SessionAttribute("USER") WechatUser user) {
		int id=Integer.parseInt(map.get("id")+"");
		if(voteInfoRepo==null)
			System.out.println("null");
		VoteInfo voteInfo=voteInfoRepo.findById(id);
		Map<String,Object> result=MapTool.Obj2Map(voteInfo);
		result.put("timedur", DateTimeTool.getFormatDate(voteInfo.getTimeCreat(), DateTimeTool.DataFormat8)+"-"+DateTimeTool.getFormatDate(voteInfo.getTimeEnd(), DateTimeTool.DataFormat8));
		return MapTool.getSuccessRes(result);
	}
	@RequestMapping(value = "/vote/createVote", method = RequestMethod.POST)
	public @ResponseBody Object createVote(@RequestBody Map<String,Object> map,@SessionAttribute("USER") WechatUser user) {
		int id=Integer.parseInt(map.get("id")+"") ;
		//
		
		return MapTool.getSuccessRes(id);
	}
	@RequestMapping(value="/vote/letvote",method = RequestMethod.POST)
	public @ResponseBody Object vote(@RequestBody Map<String,Object> map,@SessionAttribute("USER") WechatUser user) {
		int id_vote=(int) map.get("id");
		int id_user=user.getUserid();
		String result=JsonTool.toJson(map.get("result"));
		VoteItem voteItem=voteItemRepo.findByIdUserAndIdVote(id_user,id_vote);
		voteItem.setResult(result);
		voteItem.setTimeVoteLast(new Date());
		voteItem.setNum_submit(voteItem.getNum_submit()+1);
		voteItemRepo.save(voteItem);
		return MapTool.getSuccessRes("success");
	} 
	



}
