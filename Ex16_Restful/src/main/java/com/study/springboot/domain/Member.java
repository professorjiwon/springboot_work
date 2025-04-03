package com.study.springboot.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Member {
	@Id
	private String id;
	@NonNull
	private String password;
	@NonNull
	private String name;
	private String email;
	private LocalDate birthday;
	private String gender;
	private String phone;
	private String address;
	
	@CreatedDate
	@Column(name="create_date")
	private LocalDateTime createDate;
	
	@LastModifiedDate
	@Column(name="update_date")
	private LocalDateTime updateDate;
	
	// @Column(name="컬럼명", insertable=false, updatable=false, columnDefinition="DATE DEFAULT SYSDATE")
	
}
