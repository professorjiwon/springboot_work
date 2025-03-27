package com.study.springboot.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import jakarta.servlet.DispatcherType;

@Configuration
public class WebSecurityConfig {
	
	@Autowired
	AuthenticationFailureHandler authenticationFailureHandler;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// 람다형태 : request -> request (Security 7.0부터 람다식으로 변경)
		/*
		 - csrf : 사이트간 요청 위조
		 		  웹사이트의 취약점 공격의 하나
		 		  사용자가 자신의 의지와는 상관없이 공격자가 의도한 행위(수정,삭제,등록 등)를 특정 웹사이트에 요청하게 하는 공격
		 		   * 해결방법 : 서버에서 요청에 대한 검증을 하는 것(토큰 발행)
		 - cors : 웹 브라우저에서 다른 도메인(출처)의 리소스에 접근할 수 있도록 허용하는 정책
		 		  브라우저는 기본적드로 다른 출처의 리소스에 대한 요청을 제한.
		 */

		http.csrf((csrf) -> csrf.disable())
			.cors((cors) -> cors.disable())
			.authorizeHttpRequests(request -> request
				.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()	  //서버로 되돌려주는 파일들 모두 허용
				.requestMatchers("/").permitAll()
				.requestMatchers("/css/**", "/js/**", "/img/**").permitAll()
				.requestMatchers("/guest/**").permitAll()
				.requestMatchers("/member/**").hasAnyRole("USER", "ADMIN")
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()
			  );
		// springboot에서 제공해주는 form
		// http.formLogin((formLogin) -> formLogin.permitAll());
		
		// 내가 만든 form사용하기
		http.formLogin((formLogin) -> formLogin
				.loginPage("/loginForm")		// MyController에서 mapping = /loginForm를 찾음
				.loginProcessingUrl("/login_check")  // action에 넣었던 값
				//.failureUrl("/loginForm?error")
				.failureHandler(authenticationFailureHandler)
				.usernameParameter("username")  // 파라미터 가져올 때 기본값(j_username)
				.passwordParameter("pwd")		// 파라미터 가져올 때 기본값(j_password)
				.permitAll()
		);
		
		http.logout((logout) -> logout.permitAll());
		
		return http.build();
	}
	
	@Bean
	public UserDetailsService users() {
		UserDetails user = User.builder()
								.username("user")
								.password(passwordEncoder().encode("1234"))
								.roles("USER")
								.build();
		UserDetails admin = User.builder()
								.username("admin")
								.password(passwordEncoder().encode("1234"))
								.roles("ADMIN", "USER")
								.build();
		// 메모리에 사용자 정보 담기
		return new InMemoryUserDetailsManager(user, admin);
	}
	
	// passwordEncoder() : 패스워드 암호화
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}