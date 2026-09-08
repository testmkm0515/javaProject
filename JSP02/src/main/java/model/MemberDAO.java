package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;

import util.Util;

public class MemberDAO {
	//DAO 객체 생성시 connection 객체를 factory(connection pool)에서 할당받도록 생성자 구성
	private DataSource dataFactory;
	
	public MemberDAO() {
		try {
		Context ctx = new InitialContext();
        Context env =(Context)ctx.lookup("java:/comp/env");
        this.dataFactory = (DataSource)env.lookup("jdbc/oracle");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//회원정보 조회 메소드
	public ArrayList<MemberDTO> memberSelect(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<MemberDTO> memList = new ArrayList<MemberDTO>();
		
		try {
			//con = Util.getConn(); //사용할때 직접 연결
			System.out.println("chekc");
			con = dataFactory.getConnection(); //connection pool 에서 미리 준비한 connection 객체를 얻어옴
			String query = "select * from member";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {				
				String id = rs.getString("memId");
				String pwd = rs.getString("memPwd");
				String name = rs.getString("memName");
				String email = rs.getString("memEmail");
				Date joinDate = rs.getDate("memJoinDate");
				
				MemberDTO vo = new MemberDTO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				
				memList.add(vo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return memList;
		
	}
}
