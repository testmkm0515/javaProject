package com.spring_mvc.projectData;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

		@RequestMapping("/bookInfoView1")
		public String showBookInfo1(Model model) { //DI
			model.addAttribute("title", "스프링프레임워크");
			model.addAttribute("price", 20000);
			return "book/bookInfoView";
		}
		
		@RequestMapping("/bookInfoView2")
		public ModelAndView showBookInfo2(ModelAndView mView) { //DI
			mView.addObject("title", "스프링프레임워크2");
			mView.addObject("price", 25000);
			mView.setViewName("book/bookInfoView");
			return mView;
		}	
}





