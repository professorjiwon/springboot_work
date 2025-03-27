package com.study.springboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
	public SecurityFilterChain filterChain(HttpSecurity http) {
		// 람다형태 : request -> request (Security 7.0부터 람다식으로 변경)
		/*
		 * csrf : 사이트간 요청 위조
		 * 
		 */
		http.csrf()
		
		
		return null;
	}
}
