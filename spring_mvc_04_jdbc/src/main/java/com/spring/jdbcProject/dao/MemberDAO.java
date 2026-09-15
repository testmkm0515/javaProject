package com.spring.jdbcProject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.sql.DataSource;

import com.spring.jdbcProject.dto.*;

@Repository
public class MemberDAO {
	
	private DataSource dataFactory;
	
	//반환결과를 담을 DTO 필드를 추가 - 자동 주입되는 객체 공통 사용 객체(한번 들어오고 변경되지 않음)
	//의존성 주입은 객체 생성될 때 한번 주입되기 때문에 동적으로 계속 객체가 생성되는 경우 사용 불가능
	//@Autowired
	//@Qualifier("memberDTO")
	//private MemberDTO dto;
	
	@Autowired
	public MemberDAO(DataSource dataSource) {
		try {
			this.dataFactory = dataSource; //dbcp가 연동
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	//회원정보 조회 : 전체 회원정보 select 해서 반환
	public ArrayList<MemberDTO> memberSelect(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//데이터 저장해서 반환할 ArrayList 객체
		ArrayList<MemberDTO> memList = new ArrayList<MemberDTO>();
		
		try {
			System.out.println("chekc");
			con = dataFactory.getConnection(); //db con 객체 connection pool로부터 할당
			
			String sql = "select * from Member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				//local block
				String memId = rs.getString("memId");
				String memPwd = rs.getString("memPwd");
				String memName = rs.getString("memName");
				String memEmail = rs.getString("memEmail");
				Date memJoinDate = rs.getDate("memJoinDate");
				
				//MemberDTO에 담아서
				//dto 객체 인스턴스 동적 자동 주입 가능? 어노테이션 이용 해서는 불가능
				//메소드 호출 시 자동 주입은 가능한 모듈이 있음
				//local block 안에서는 자동 주입 불가능
				//@Autowired(required=false)
				//@Qualifier(value="memberDTO")				
				MemberDTO dto = new MemberDTO() ;		
				//local 참조변수는 초기화 후에 사용 가능 함
				dto.setMemId(memId);
				dto.setMemPwd(memPwd);
				dto.setMemName(memName);
				dto.setMemEmail(memEmail);
				dto.setMemJoinDate(memJoinDate);				
				//ArrayList에 추가
				memList.add(dto);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				System.out.println("con : "+con);
				rs.close();
				pstmt.close();
				con.close(); //커넥션풀로 객체 반환
			}catch(Exception e) {}
		}
		return memList;
	}
}
















