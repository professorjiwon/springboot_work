package com.study.springboot.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="jpapaging")
public class Member {
	@Id
	@SequenceGenerator (
		name="pagingseq",
		sequenceName="jpapaging_seq",
		initialValue=1,
		allocationSize=1
	)
	@GeneratedValue(generator = "pagingseq")
	private Long id;	
	private String name;
	private String email;
}
