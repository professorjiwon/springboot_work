package com.study.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Member;
import com.study.springboot.dto.UserDto;
import com.study.springboot.repository.MemberRepository;

@Service
public class MemberRestService {
	
	@Autowired
	MemberRepository memberRepository;

	public Member saveUserDto(UserDto userDto) {
		Member member = new Member();
		member.setId(userDto.getId());
		member.setName(userDto.getName());
		member.setPassword("1234");
		
		return memberRepository.save(member);
	}
	
	

}
