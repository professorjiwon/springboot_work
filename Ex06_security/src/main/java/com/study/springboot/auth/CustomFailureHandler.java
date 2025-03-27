package com.study.springboot.auth;

import java.io.IOException;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class CustomFailureHandler implements AuthenticationFailureHandler {
							// 사용자 인증에 실패 했을 때 처리를 담당하는 핸들러
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		String loginId = request.getParameter("username");
		String errormsg = "";
		
		if(exception instanceof BadCredentialsException) {
			errormsg = "아이디나 비밀번호가 맞지 않습니다.";
		} else if(exception instanceof InternalAuthenticationServiceException) {
			errormsg = "아이디나 비밀번호가 맞지 않습니다.";
		} else if(exception instanceof DisabledException) {
			errormsg = "계정이 비활성화 되었습니다. 관리자에게 문의하세요.";
		} else if(exception instanceof AccountExpiredException) {
			errormsg = "비밀번호 유효기간이 만료되었습니다. 관리자에게 문의하세요.";
		}
		
		request.setAttribute("username", loginId);
		request.setAttribute("error_message", errormsg);
		
		request.getRequestDispatcher("/loginForm?error=true").forward(request, response);
	}
}
