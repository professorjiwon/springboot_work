package com.study.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.study.springboot.service.BoardService;

@Controller
@SessionAttributes("loginUser")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/list")
	public String list(@RequestParam(value="nowPage", defaultValue="0") int nowPage, Model model) {
//		Page<Board> pageList = boardService.list(PageRequest.of(nowPage, 10, Sort.by(Sort.Direction.DESC, "bno")));
//		
//		model.addAttribute("boardList", pageList);
//		model.addAttribute("nowPage", nowPage);
		return "board/list";
	}
	
	@GetMapping("/insertForm")
	public String insertForm() {
		return "board/insertForm";
	}

}
