package com.study.springboot.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
	
	@RequestMapping("/selectByEmail")
	public String selectByEmail(@RequestParam("email") String email, Model model) {
		Optional<Member> member = memberService.selectByEmail(email);
		if(member.isPresent()) {
			model.addAttribute("member", member.get());
		} else {
			model.addAttribute("member", null);
		}
		return "select";
	}
	
	@RequestMapping("/selectByNameLike")
	public String selectByNameLike(@RequestParam("name") String name, Model model) {
		//	%김%, 김%, %김
		String name2 = "%" + name + "%";
		List<Member> member = memberService.selectByNameLike(name2);
		model.addAttribute("members", member);
		return "selectAll";
	}

	@RequestMapping("/selectByNameLikeNameDesc")
	public String selectByNameLikeNameDesc(@RequestParam("name") String name, Model model) {
		//	%김%, 김%, %김
		String name2 = "%" + name + "%";
		List<Member> member = memberService.selectByNameLikeNameDesc(name2);
		model.addAttribute("members", member);
		return "selectAll";
	}

	@RequestMapping("/selectByNameLikeNameSort")
	public String selectByNameLikeNameSort(@RequestParam("name") String name, Model model) {
		//	%김%, 김%, %김
		String name2 = "%" + name + "%";
		/*
		 * Sort / Sort.Order
		   - Spring Framework 일부, 데이터 정렬을 지정하는데 사용
		   - Sort 클래스는 하나이상의 Sort.Order 객체를 가지고 있음
		     ex) 2개 이상일 때
		     Sort sort = Sort.by(
		     					Sort.Order.desc("name"),
		     					Sort.Order.asc("email")
		     					);
		 */
		Sort sort = Sort.by(Sort.Order.desc("name"));
		Sort sort2 = Sort.by(Sort.Order.desc("name"),Sort.Order.asc("email"));
		List<Member> member = memberService.selectByNameLikeSort(name2, sort);
		model.addAttribute("members", member);
		return "selectAll";
	}
}





