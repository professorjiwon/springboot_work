package com.study.springboot.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
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
@Entity(name="MemberJpa1")
public class Member {
	@Id
	@GeneratedValue
	private Long id;
	
	private String username;
	
	@Column(name="create_date")
	private LocalDate createDate;

}
