package com.spring_boot.projectEx.dao;

import java.util.HashMap;

import com.spring_boot.projectEx.dto.MemberDTO;

public interface IMemberDAO {
	//public String loginCheck(HashMap<String, Object> map) ;
	public String loginCheck(String id) ; //id의 레코드가 있으면 해당 레코드의 비밀번호를 반환
	public void insertMember(MemberDTO dto);
	public String idCheck(String id);
}
