package com.study.springboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.domain.Member;
import com.study.springboot.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/")
	public String root() {
		return "index";
	}
	
	@PostMapping("/enroll")
	public String enroll(Member member, Model model) {
		Member result = memberService.insert(member);
		model.addAttribute("member", result);
		return "memberEnroll";
	}

	@PostMapping("/memUpdate")
	public String memUpdate(Member member, Model model) {
		Optional<Member> rm = memberService.selectById(member.getId());
		Member m = rm.get();
		member.setCreatedAt(m.getCreatedAt());
		
		Member result = memberService.insert(member);
		model.addAttribute("member", result);
		return "memberEnroll";
	}
}