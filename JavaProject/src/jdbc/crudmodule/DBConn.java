package jdbc.crudmodule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConn {
	//db 연결 및 종료 관리
	public static Connection getConnection() {
		Connection con = null;

		try {
			String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
			String user = "sql_select";
			String pwd = "1234";
			con = DriverManager.getConnection(url, user, pwd);

		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//1. db 관련 객체 종료
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
				rs=null;
			}
			
			if(pstmt != null) {
				pstmt.close();
				pstmt=null;
			}	
			
			if(con != null) {
				con.close();
				con=null;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//2. Connection, PreparedStatement 자원 2개 반환
	public static void close(Connection con, PreparedStatement pstmt ) {
		try {
	
			if(pstmt!=null) {
				pstmt.close();
				pstmt=null;
			}
			
			if(con!= null) {
				con.close();
				con=null;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//3. Connection 자원 1개 반환
	public static void close(Connection con) {
		try {
		
			if(con!= null) {
				con.close();
				con=null;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//4. PreparedStatement, Resultset 자원 2개 반환
	public static void close(PreparedStatement pstmt, ResultSet rs) {
		try {
		
			if(rs!= null) {
				rs.close();
				rs=null;
			}
			
			if(pstmt!= null) {
				pstmt.close();
				pstmt=null;
			}			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}	
	
	//5. PreparedStatement 자원 1개 반환
	public static void close(PreparedStatement pstmt) {
		try {
			
			if(pstmt!= null) {
				pstmt.close();
				pstmt=null;
			}			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}		
	
	
}







