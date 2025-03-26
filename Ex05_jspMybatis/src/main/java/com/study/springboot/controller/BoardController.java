package com.study.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	
	
	@RequestMapping("/")
	public String root() {
		return "list";
	}
	
	/*
	 * 요청 처리 후 응답페이지로 포워딩 또는 url재요청시 응답데이터를 담는 방법
	   1. Model객체
	      포워딩할 뷰로 전달하고자하는 데이터를 맵형식<key-value>로 담을 수 있다
	      requestScope임.
	      *** 단, setAttribute가 아닌 addAttribute메소드를 이용
	   
	   2. ModelAndView객체
	   	  Model은 데이터를 맵형식<key-value>으로 담고,
	   	  View는 응답뷰에 대한 정보를 담을 수 있는 공간
	 */
	
	@RequestMapping("/list")
	public String listPage(Model model) {
		
	}
}
