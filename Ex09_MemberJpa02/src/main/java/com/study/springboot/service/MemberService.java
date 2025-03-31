package com.study.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

	public Optional<Member> selectByEmail(String email) {
		return memberRepository.findByEmail(email);
	}

	public List<Member> selectByNameLike(String name2) {
		return memberRepository.findByNameLike(name2);
	}

	public List<Member> selectByNameLikeNameDesc(String name2) {
		// return memberRepository.findByNameLikeOrderByName(name2); ->오름차순 정렬
		// return memberRepository.findByNameLikeOrderByNameDescOrderByEmail(name2);
		return memberRepository.findByNameLikeOrderByNameDesc(name2);
	}


	public List<Member> selectByNameLikeSort(String name2, Sort sort) {
		return memberRepository.findByNameLike(name2, sort);
	}
}
