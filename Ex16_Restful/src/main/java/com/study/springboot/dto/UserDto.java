package com.study.springboot.dto;

import com.study.springboot.domain.Member;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
	private String id;
	private String name;
	
	public UserDto(Member m) {
		this.id = m.getId();
		this.name = m.getName();
	}
}
