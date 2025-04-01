package com.study.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Member;
import com.study.springboot.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	MemberRepository memberRepository;

	public List<Member> selectNameLike1(String name) {
		return memberRepository.findMembers(name);
		//return memberRepository.findByNameLike(name);
	}

	public List<Member> selectNameLike2(String name, Sort sort) {
		return memberRepository.findMembers(name, sort);
	}

	public Page<Member> selectNameLike3(String name, Pageable pageable) {
		return memberRepository.findMembers(name, pageable);
	}

	public List<Member> selectNameLike4(String name) {
		return memberRepository.findMembersNative(name);
	}


}
