package com.spring_boot_react.project.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


import com.spring_boot_react.project.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService service;
	
	@GetMapping("/")
	public String viewIndex() {
		return "index";
	}	

}

























