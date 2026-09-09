package com.di.spring_di_xml_constructor;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class NameMain {

	public static void main(String[] args) {
		//스프링 컨테이너 객체 생성 - 의존성 설정 파일을 컨테이너에게 전달
		//스프링컨테이너 모듈 컨텍스트 모듈로 제공
		//xml 파일로 설정을 진행 -> xml을 파악하는 컨텍스트 필요
		
		AbstractApplicationContext context = new GenericXmlApplicationContext("application-context.xml");
		
		//bean 컴포넌트 가져와 controller에 대입
		NameController controller = context.getBean("nameController",NameController.class);
		controller.show("홍길동");
		context.close();

	}

}
