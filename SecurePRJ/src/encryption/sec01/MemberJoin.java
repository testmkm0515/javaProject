package encryption.sec01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import encryption.sec02.DBConn;

public class MemberJoin {
	public static void main(String[] args) {
	//취약한 패스워드 저장 1 : plain text 그대로 저장
	DBConn dbCon = new DBConn();
	Connection con = dbCon.getConnection();
	PreparedStatement pstmt = null;
	
	Scanner sc = new Scanner(System.in);
	
	try {
		System.out.print("ID 입력 : ");
		String memID = sc.nextLine();
		System.out.print("비밀번호 입력 : ");//취약한 패스워드 저장 1 : plain text 그대로 저장
		String memPass = sc.nextLine();
		System.out.print("이름 입력 : ");
		String memName = sc.nextLine();
		System.out.print("e-mail 입력 : ");
		String memEmail = sc.nextLine();
		
		//회원가입시간
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String memJoinDate = now.format(formatter);

		String sql = "insert into member values(?,?,?,?,?)" ;
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, memID);
		pstmt.setString(2, memPass); //바인딩되는 패스워드 plain text
		pstmt.setString(3, memName);
		pstmt.setString(4, memEmail);
		pstmt.setString(5, memJoinDate);
		
		int result = pstmt.executeUpdate();
		
		if(result > 0) {
			System.out.println("회원가입 성공");
		}else {
			System.out.println("회원가입 실패");
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	}
}

	
	
	
	
	
	
	
	
	
	
	
	