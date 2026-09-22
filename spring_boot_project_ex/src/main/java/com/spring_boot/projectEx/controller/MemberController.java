package com.spring_boot.projectEx.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring_boot.projectEx.dto.MemberDTO;
import com.spring_boot.projectEx.service.IMemberService;
import com.spring_boot.projectEx.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	@Autowired
	@Qualifier("MemberService")
	IMemberService memService;
	
	//로그인 폼 요청
	@GetMapping("/member/loginForm")
	public String loginForm() {
		return "member/loginForm";
	}
	
	//로그인 처리
	@ResponseBody
	@PostMapping("/member/login")
	public String loginCheck(@RequestParam HashMap<String,Object> param,HttpSession session) {
		String result = memService.loginCheck(param);
		//로그인 성공시 session 속성 추가->로그인 유지
		if(result == "success") {
			System.out.println((String)param.get("id"));
			session.setAttribute("sid", param.get("id"));
		}
		return result;
	}
	
	//회원가입 폼 요청
	@GetMapping("/member/joinForm")
	public String joinForm() {
		return "member/joinForm";
	}
	
	//id 중복 체크 요청 처리
	@ResponseBody
	@PostMapping("/member/idCheck")
	public int idCheck(@RequestParam String id) {
		String id_res = memService.idCheck(id);
		int result=0;
		if(id_res != null) { //기존 id가 있음
			result=1;
		}
		return result;
	}
	
	//회원가입
	@PostMapping("/member/join")
	public String join(MemberDTO dto, @RequestParam("memHp1") String memHp1,
									  @RequestParam("memHp2") String memHp2,
									  @RequestParam("memHp3") String memHp3) {
		String memHp = memHp1 + "-" + memHp2 + "-" + memHp3;
		dto.setMemHp(memHp);
		memService.insertMember(dto); //회원가입 완료 후
		return "redirect:/member/loginForm"; //로그인 폼 요청
	}
}


















