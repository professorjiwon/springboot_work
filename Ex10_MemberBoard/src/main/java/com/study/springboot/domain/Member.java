package com.study.springboot.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Member1")
@EntityListeners(AuditingEntityListener.class)
public class Member {
	@Id
	private String id;	
	private String name;
	private String password;

	// 엔티티가 생성된 시간
	@CreatedDate		// 엔티티가 생성된 시간 저장
	@Column(name="created_at")
	private LocalDateTime createdAt;
	
	// 엔티티가 수정된 시간
	@LastModifiedDate	// 엔티티가 수정될 때 수정된 시간 저장
	@Column(name="updated_at")
	private LocalDateTime updatedAt;
}
