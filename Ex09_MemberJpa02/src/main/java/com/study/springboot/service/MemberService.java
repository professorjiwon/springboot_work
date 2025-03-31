package com.study.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Member;
import com.study.springboot.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	MemberRepository memberRepository;

	public void insert() {
		Member member;
		member = new Member("더조은", "test1@test.com");
		memberRepository.save(member);
		
		member = new Member("이조은", "test2@test.com");
		memberRepository.save(member);
		
		member = new Member("김조은", "test3@test.com");
		memberRepository.save(member);
		
		member = new Member("박조은", "test4@test.com");
		memberRepository.save(member);
		
		member = new Member("최조은", "test5@test.com");
		memberRepository.save(member);
		
		member = new Member("강조은", "test7@test.com");
		memberRepository.save(member);
		
		member = new Member("양조은", "test8@test.com");
		memberRepository.save(member);
	}

	public List<Member> selectAll() {
		return memberRepository.findAll();
	}

	public Optional<Member> select(Long id) {
		return memberRepository.findById(id);
	}

	public Optional<Member> selectByName(String name) {
		return memberRepository.findByName(name);
	}
}
