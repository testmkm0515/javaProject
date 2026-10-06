package com.spring_boot_react.project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity //사용중인 웹 보호 구성과 관련 설정->기본 웹보호구성중 아래 클래스에서 설정되는 구성은 해제하고 자체 구성 정의 가능하게 함
public class SecurityConfig {
	//InMemory User 생성 객체 반환
	//스프링 시큐리티가 제공하는 인메모리유저(user)의 비밀번호 변경 목적
	//개발단계에서 주로 인메모리 유저 사용 - 배포시에는 db에 저장해야 함
	@Bean
	public InMemoryUserDetailsManager userDetailService() {
		UserDetails user = User.builder().username("user")
							.password(passwordEncoder().encode("password"))
							.roles("USER").build();
		return new InMemoryUserDetailsManager(user);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
