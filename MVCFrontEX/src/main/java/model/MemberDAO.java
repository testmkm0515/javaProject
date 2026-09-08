package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private DataSource dataFactory;
	private Connection conn;
	private PreparedStatement pstmt;
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envCtx = (Context)ctx.lookup("java:/comp/env");
			this.dataFactory = (DataSource) envCtx.lookup("jdbc/oracle");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> listMembers(){
		List<MemberVO> memberList = new ArrayList();
		
		try {
			conn = dataFactory.getConnection();
			String query = "select * from member order by MEMJOINDATE desc";
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("MEMID");
				String pwd = rs.getString("MEMPWD");
				String name = rs.getString("MEMNAME");
				String email = rs.getString("MEMEMAIL");
				Date joinDate = rs.getDate("MEMJOINDATE");
				MemberVO memVO = new MemberVO(id,pwd,name,email,joinDate);
				memberList.add(memVO);
			}
			rs.close();
			pstmt.close();
			conn.close();//connection pool로 반환
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return memberList;
	}
	
	public void addMember(MemberVO m) {
		try {
			conn = dataFactory.getConnection();
			String id = m.getId();
			String pwd = m.getPwd();
			String name = m.getName();
			String email = m.getEmail();
			String query = "INSERT INTO member (memid, mempwd, memname, mememail)" + " VALUES(?, ? ,? ,?)";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public MemberVO findMember(String _id) {
		MemberVO memInfo = null;
		try {
			conn = dataFactory.getConnection();
			String query = "select * from  member where memid=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, _id);
			System.out.println(query);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			String id = rs.getString("memid");
			String pwd = rs.getString("mempwd");
			String name = rs.getString("memname");
			String email = rs.getString("mememail");
			Date joinDate = rs.getDate("memjoinDate");
			memInfo = new MemberVO(id, pwd, name, email, joinDate);
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memInfo;
	}
	
	public void modMember(MemberVO memberVO) {
		String id = memberVO.getId();
		String pwd = memberVO.getPwd();
		String name = memberVO.getName();
		String email = memberVO.getEmail();
		try {
			conn = dataFactory.getConnection();
			String query = "update member set mempwd=?,memname=?,mememail=?  where memid=?";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pwd);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, id);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delMember(String id) {
		try {
			conn = dataFactory.getConnection();
			String query = "delete from member where memid=?";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}

























