package com.study.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.domain.Reply;
import com.study.springboot.service.ReplyService;

@Controller
public class ReplyController {
	
	@Autowired
	ReplyService replyService;
	
	@PostMapping("/rInsert")
	@ResponseBody
	public List<Reply> rInsert(Reply reply) {
		System.out.println("댓글 내용 : " + reply.getContent());
		Reply r = replyService.rInsert(reply);
		if(r != null) {
			return replyService.seletAll(reply.getRefBno());
		} else {
			return null;
		}
	}

}
