package com.spring_mvc.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//일반 컨트롤러 - 요청 처리 - 요청의 전달은 프론트컨트롤러로 부터 전달
@Controller
public class NewController {

		@RequestMapping("/newView") // /newView 요청이 들어오면 요청을 받아 처리할 메소드 newView()
		public String newView() {
			return "NewView"; //뷰리졸버에 의해 /WEB-INF/views/newView.jsp가  view로 선택됨
		}
}
