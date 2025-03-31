package com.study.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Member;
import com.study.springboot.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	MemberRepository memberRepository;

	public Member insert(Member member) {
		return memberRepository.save(member);
	}

	public Optional<Member> selectById(String id) {
		return memberRepository.findById(id);
	}

	
}
