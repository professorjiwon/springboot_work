package com.study.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuController {
	
	@RequestMapping("/menuForm")
	public String menuForm() {
		return "menu/menuForm";
	}
}
