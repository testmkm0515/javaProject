package com.spring_mvc.projectData.data2;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController1 {
	@RequestMapping("/student/studentForm2")
	public String studentFormView2() {
		return "student/studentForm4";
	}
	
	@RequestMapping("/student/newStudent6")
	public String insertStudent6(Student1 student1) {
		return "student/studentResult4";
	}

}
















































