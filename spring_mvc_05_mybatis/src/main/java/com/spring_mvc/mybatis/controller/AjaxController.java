package com.spring_mvc.mybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {

	//로그인 폼 열기
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "ajax/loginForm";
	}
	
	//로그인 처리
	@ResponseBody //메소드의 return값을 ResponseBody에 포함해서 응답
	@RequestMapping("/login")
	public String loginCheck(@RequestParam("id") String id,
							 @RequestParam("pw") String pw) {
		String result="";
		if(id.equals("abcd") && pw.equals("1234"))
			result ="success";
		else
			result = "fail";
		return result;  //반환값은 view 페이지 이름으로 약속되어 있음
		// result변수에 저장된 값 그대로 반환(클라이언트에게 응답)하려면? 메소드에 @ResponseBody 추가
	}
}
