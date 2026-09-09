package com.di.spring_di_annotation.component2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

//@Component
@Controller
public class NameController {

	@Autowired
	INameInterface nameService; 
	
	public void show(String name) {
		System.out.println("NameController : "  + nameService.showName(name));
	}
}
