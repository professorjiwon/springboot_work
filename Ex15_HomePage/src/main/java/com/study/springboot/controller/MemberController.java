package com.study.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.study.springboot.domain.Member;
import com.study.springboot.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("loginUser")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	PasswordEncoder pEncoder;
	
	@RequestMapping("/")
	public String root() {
		return "index";
	}
	
	@GetMapping("/enrollForm")
	public String enrollForm() {
		return "member/enrollForm";
	}
	
	@GetMapping("/idCheck")
	@ResponseBody
	public boolean idCheck(@RequestParam("id") String id) {
		return memberService.idCheck(id);
	}
	
	@PostMapping("/memberInsert")
	public String insert(Member member) {
		String enPass = pEncoder.encode(member.getPassword());
		member.setPassword(enPass);
		memberService.insert(member);
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(Member member, Model model) {
		Member loginUser = memberService.login(member);
		
		if(loginUser != null && pEncoder.matches(member.getPassword(), loginUser.getPassword())) {
			model.addAttribute("loginUser", loginUser);  
			// request scope -> session scope로 변환
			//   class에 추가 어노테이션 추가(@SessionAttributes({"loginUser","여러개"}))
		}
		return "redirect:/";
	}
	
	

}
