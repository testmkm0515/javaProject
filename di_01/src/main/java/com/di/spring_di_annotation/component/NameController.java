package com.di.spring_di_annotation.component;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NameController {

	@Autowired
	INameInterface nameService; 
	
	public void show(String name) {
		System.out.println("NameController : "  + nameService.showName(name));
	}
}
