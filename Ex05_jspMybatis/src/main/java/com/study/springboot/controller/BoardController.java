package com.study.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.domain.Board;
import com.study.springboot.service.BoardService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/")
	public String root() {
		return "redirect:list";
	}

	@RequestMapping("/list")
	public String listPage(Model model) {
		List<Board> list = boardService.list();
		int record = boardService.totalRecord();
		
		model.addAttribute("list", list);
		model.addAttribute("totalRecord", record);
		return "list";
	}
	
	@GetMapping("/detail")
	public String detailView(HttpServletRequest request, Model model) {
		String boardno = request.getParameter("boardno");
		
		// Board board = boardService.detailBoard(boardno);
		model.addAttribute("board", boardService.detailBoard(boardno));
		return "detail";
	}
}
