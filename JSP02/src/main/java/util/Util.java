package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Util {
	private static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//"oracle 접속종류:@dbms주소(도메인,ip):포트:sid 또는 포트/서비스name
			String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
			String user = "SQL_SELECT";//오라클은 계정 정보가 DB임
			String pwd = "1234";
			
			con = DriverManager.getConnection(url,user,pwd);
			
			if(con!=null) {
				System.out.println("DB 연결 성공");
			}else {
				System.out.println("DB 연결 실패");
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static Connection getConn() {
		return getConnection();
	}
	
}






