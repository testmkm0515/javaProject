package secure.exam;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public Connection getConnection() { //메소드 호출되면 db 연결 진행하고 연결된 객체 반환
		Connection con = null;
		// 예외처리 필요
		try {

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "C##SQL_USER";
			String pwd = "1234";
			
			con = DriverManager.getConnection(url, user, pwd); // db 연결이 성공되면 객체가 반환 실패하면 null 값이 반환
			
			if(con != null) {
				System.out.println("db 연결 성공");
			}else {
				System.out.println("db 연결 실패");
			}
			return con; //dbms 연결된 connection 객체 리턴
			
		} catch(Exception e) {
			e.printStackTrace(); //오류 발생할때까지의 과정을 추적해서 오류 내용 출력
			return null; //연결 실패시 오류 출력 후 null 리턴
		}		
	}
}
