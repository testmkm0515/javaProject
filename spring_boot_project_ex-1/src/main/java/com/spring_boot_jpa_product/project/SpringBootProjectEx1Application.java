package com.spring_boot_jpa_product.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.spring_boot_jpa_product.project"})
public class SpringBootProjectEx1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectEx1Application.class, args);
	}

}
