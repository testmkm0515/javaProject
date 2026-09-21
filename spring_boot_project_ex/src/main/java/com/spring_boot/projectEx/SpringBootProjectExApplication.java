package com.spring_boot.projectEx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.spring_boot.projectEx"})
public class SpringBootProjectExApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectExApplication.class, args);
	}

}
