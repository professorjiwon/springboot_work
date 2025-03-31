package com.study.springboot.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="MemberJpa2")
public class Member {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String email;

	public Member(String name, String email) {
		this.name = name;
		this.email = email;
	}
}
