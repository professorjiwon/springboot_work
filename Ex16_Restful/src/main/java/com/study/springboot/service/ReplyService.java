package com.study.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Reply;
import com.study.springboot.repository.ReplyRepository;

@Service
public class ReplyService {
	
	@Autowired
	ReplyRepository replyRepository;

	public List<Reply> seletAll(Long bno) {
		return replyRepository.findByRefBnoOrderByRnoDesc(bno);
	}

	public Reply rInsert(Reply reply) {
		return replyRepository.save(reply);	
	}
}
