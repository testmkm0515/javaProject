package com.spring_boot_react.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.spring_boot_react.project"})
@MapperScan(basePackages= {"com.spring_boot_react.project"})
public class SpringBootReactApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootReactApplication.class, args);
	}

}
