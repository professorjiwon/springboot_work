package com.study.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Member;
import com.study.springboot.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	MemberRepository memberRepository;
	
	public Member insert(Member member) {
		// save() : jpa에서 insert메소드
		//			동일한키가 있으면 update, 키가 없으면 insert
		
		Member result = memberRepository.save(member);
		return result;
	}

}
