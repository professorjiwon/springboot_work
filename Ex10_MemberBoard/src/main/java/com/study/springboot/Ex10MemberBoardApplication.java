package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/*
 * @EnableJpaAuditing : DB에 데이터가 저장되거나 수정될 때 언제, 누가 했는지를 자동으로 관리
 */
@EnableJpaAuditing
@SpringBootApplication
public class Ex10MemberBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex10MemberBoardApplication.class, args);
	}

}
