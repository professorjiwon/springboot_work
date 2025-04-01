package com.study.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		return "index";
	}
	
	@GetMapping("/selectNameLike1")
	public String selectNameLike1(@RequestParam("name") String search, Model model) {
		String name = search + "%";

		List<Member> result = memberService.selectNameLike1(name);

		model.addAttribute("members", result);
		
		return "selectNameList1";
	}
	
	@GetMapping("/selectNameLike2")
	public String selectNameLike2(@RequestParam("name") String search, Model model) {
		String name = search + "%";
		Sort sort = Sort.by(Sort.Order.asc("id"));
		
		List<Member> result = memberService.selectNameLike2(name, sort);
		
		model.addAttribute("members", result);
		
		return "selectNameList1";
	}
	
	@GetMapping("/selectNameLike3")
	public String selectNameLike3(@RequestParam("name") String search, 
								  @RequestParam("page") int page,
								  Model model) 
	{
		String name = search + "%";
		Sort sort = Sort.by(Sort.Order.desc("id"));
		Pageable pageable = PageRequest.of(page-1, 10, sort);
		
		Page<Member> result = memberService.selectNameLike3(name, pageable);
		
		List<Member> member = result.getContent();
		long totalRecord = result.getTotalElements();
		int totalPage = result.getTotalPages();
		
		model.addAttribute("members", member);
		model.addAttribute("totalRecord", totalRecord);
		model.addAttribute("totalPage",totalPage);
		
		return "selectNameList2";
	}
	
	@GetMapping("/selectNameLike4")
	public String selectNameLike4(@RequestParam("name") String search, Model model) {
		String name = search + "%";

		List<Member> result = memberService.selectNameLike4(name);

		model.addAttribute("members", result);
		
		return "selectNameList1";
	}
	
}





