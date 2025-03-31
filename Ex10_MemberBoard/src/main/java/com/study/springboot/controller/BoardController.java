package com.study.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.study.springboot.domain.Board;
import com.study.springboot.domain.Member;
import com.study.springboot.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@PostMapping("/bInsert")
	public String boardInsert(Board board, Model model) {
		Member m = new Member();
		m.setId("user02");
		
		board.setMember(m);
		Board result = boardService.insert(board);
		model.addAttribute("board", result);
		return "boardInsert";
	}
}
