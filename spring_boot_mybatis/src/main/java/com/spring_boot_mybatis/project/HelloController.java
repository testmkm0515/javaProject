package com.spring_boot_mybatis.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	
	//@RequestMapping("/")
	//@ResponseBody
	@GetMapping("/hello")
	public String home(Model model) {
		System.out.println("Hello Boot!");
		model.addAttribute("message", "hello");
		return "home";
	}
}
