package com.di.spring_di_annotation.configuration_bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BmiMain {

	public static void main(String[] args) {
		//IOC 컨테이너 객체 구성
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);		
		
		Member member = context.getBean("member", Member.class);
		System.out.println(member);
	
	}

}
