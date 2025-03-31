package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class Ex11JpaPagingApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex11JpaPagingApplication.class, args);
	}

}
