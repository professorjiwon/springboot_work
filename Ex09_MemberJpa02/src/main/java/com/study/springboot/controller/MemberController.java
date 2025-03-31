package com.study.springboot.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.domain.Member;
import com.study.springboot.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/")
	public String root() {
		return "menu";
	}
	
	@RequestMapping("/insert")
	public String insert() {
		memberService.insert();
		return "redirect:selectAll";
	}
	
	@RequestMapping("/selectAll")
	public String selectAll(Model model) {
		List<Member> list = memberService.selectAll();
		model.addAttribute("members", list);
		return "selectAll";
	}
	
	
	@RequestMapping("/select")
	public String selectAll(@RequestParam("id") Long id, Model model) {
		Optional<Member> member = memberService.select(id);
		if(member.isPresent()) {
			model.addAttribute("member", member.get());
		} else {
			model.addAttribute("member", null);
		}
		return "select";
	}
	
	@RequestMapping("/selectByName")
	public String selectByName(@RequestParam("name") String name, Model model) {
		Optional<Member> member = memberService.selectByName(name);
		if(member.isPresent()) {
			model.addAttribute("member", member.get());
		} else {
			model.addAttribute("member", null);
		}
		return "select";
	}
}





