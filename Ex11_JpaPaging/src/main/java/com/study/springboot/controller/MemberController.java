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
	
	@GetMapping("/selectNameLike")
	public String selectNameLike(@RequestParam("name") String name, 
								 @RequestParam("page") String page,
								 Model model) 
	{
		String name2 = name + "%";
		int nPage = Integer.parseInt(page) - 1;
		
		/*
		 * Pageable 인터페이스
		   : Spring에서는 Pagenation을 지원하는 인터페이스 제공
		   - getPageNumber() : 현재 페이지 번호를 반환(0부터 시작)
		   - getPageSize() : 한 페이지당 최대 레코드 수를 반환
		   - getOffset() : 현재 페이지의 시작 위치를 반환
		   - getSort() : 정렬 정보를 반환
		   - next() : 다음 페이지 정보를 반환
		   - previous() : 이전 페이지 정보를 반환
		   
		 * PageRequest 클래스
		   : Spring Data JPA에서 제공하는 Pageable 구현제 중 하나, 페이지 정보를 생성하는 클래스
		   - page : 조회할 페이지 번호(0부터 시작)
		   - size : 한 페이지당 최대 레코드 수
		   - sort : 정렬 정보(생략가능)
		   - direction : 정렬방향(asc, desc)
		   - properties : 정렬 대상 속성명
		   
		   > 생성자
		     PageRequest(int page, int size)
		     PageRequest(int page, int size, Sort sort)
		     PageRequest(int page, int size, Sort.Direction direction, String... properties)
		 */
		
		
		/*  페이징 처리 기본
		PageRequest.ofSize(10)
				   .withPage(nPage)
				   .withSort(null);
				   
		or
		
		Pageable pageable = PageRequest.of(nPage, 10);
		*/
		
		// 이름 내림차순 정렬하여 1page에 해당하는 레코드 가져오기
		Sort sort = Sort.by(Sort.Order.desc("name"));
		Pageable pageable = PageRequest.of(nPage, 10, sort);		
		// Pageable pageable = PageRequest.of(nPage, 10, Sort.by("name").descending());
		
		
		Page<Member> result = memberService.selectNameLike(name2, pageable);
		
		List<Member> member = result.getContent();		// 실제 객체가 담긴 List<Member>
		long totalElements = result.getTotalElements(); // 총 레코드 수(24개)
		int totalPages = result.getTotalPages();		// 총 페이지 수(3page)
		int size = result.getSize();					// 한페이지당 최대 레코드 수
		int pageNumber = result.getNumber() + 1;		// 현재페이지(0부터 시작하므로 + 1)
		int numberOfElements = result.getNumberOfElements();	// 현재페이지의 content 개수
		
		model.addAttribute("members", member);
		model.addAttribute("totalElements", totalElements);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("size", size);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("numberOfElements", numberOfElements);
		
		return "selectListPage";
	}
}





