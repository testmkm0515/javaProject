package com.di.spring_di_annotation.component2;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class NameService implements INameInterface{
	
	@Override
	public String showName(String name) {
		System.out.println("NameService showName()메소드");
		String myName = "내 이름은" + name + "입니다";
		return myName;
	}
}
