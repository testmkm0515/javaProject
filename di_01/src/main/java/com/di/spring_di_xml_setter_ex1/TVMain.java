package com.di.spring_di_xml_setter_ex1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVMain {

	public static void main(String[] args) {
		//스프링 컨테이너 구성		
		AbstractApplicationContext context = new GenericXmlApplicationContext("application-context2_1xml.xml");
		TV tv = context.getBean("tv", TV.class); //Speaker 객체가 setter통해서 주입됨
		
		tv.volumeDown();
		tv.volumeDown();
		
		context.close();

	}

}
