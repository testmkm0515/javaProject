package com.spring_boot.projectEx;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity //web security는 현재 클래스 설정을 따를것
public class WebSecurityConfig {
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
			.csrf(csrf->csrf.disable()) //csrf 토큰 사용하지 않도록
			.formLogin(formLogin -> formLogin.disable()) //스프링 시큐리티 자동 로그인기능 제거
			.headers(headerConfig->
					 headerConfig.frameOptions(frameOptionsConfig->
							 					frameOptionsConfig.disable()));//iframe 태그 페이지는 표현되지 않도록
		return http.build();
	}
	
	
}
