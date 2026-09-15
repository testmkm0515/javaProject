package com.spring.jdbcProject.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.jdbcProject.dao.MemberDAO;
import com.spring.jdbcProject.dto.MemberDTO;

@Controller
public class MemberController {
	
	@Autowired
	MemberDAO memDao;
	
	//시작시 요청되는 index
	@RequestMapping("/")
	public String viewIndex() {
		return "index"; //view 파일명 반환
	}
	
	//요청->비지니스 로직 처리 -> view 반환
	@RequestMapping("/member/memberSelect")
	public String selectMember(Model model) {
		//dao 반환 결과값 받는 참조변수
		//비즈니스 로직을 처리하는 dao를 컨트롤러가 직접 접근 처리하는건 권장하지 않음
		//ORM 방식의 비즈니스 로직처리 에서는 service라는 개념을 하나 추가해서 중계자 역할을 하게 함
		ArrayList<MemberDTO> memList = memDao.memberSelect();
		
		model.addAttribute("memList",memList);
		
		return "member/memberListView";
	}

}














