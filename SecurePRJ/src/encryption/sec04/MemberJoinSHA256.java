package encryption.sec04;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MemberJoinSHA256 {
	public static String sha256(String msg) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(msg.getBytes());
		return bytesToHex(md.digest());		
	}
	
	public static String bytesToHex(byte[] bytes) {
		StringBuilder builder = new StringBuilder();
		for(byte b : bytes) {
			builder.append(String.format("%02x",b));
		}
		return builder.toString();
	}
	
	public static void main(String[] args) throws Exception {
	//패스워드 암호화 : sha256+키 스트레칭
	DBConn dbCon = new DBConn();
	Connection con = dbCon.getConnection();
	PreparedStatement pstmt = null;
	
	Scanner sc = new Scanner(System.in);
	
	try {
		System.out.print("ID 입력 : ");
		String memID = sc.nextLine();
		System.out.print("비밀번호 입력 : ");
		String memPass = sc.nextLine();		
		System.out.print("이름 입력 : ");
		String memName = sc.nextLine();
		System.out.print("e-mail 입력 : ");
		String memEmail = sc.nextLine();
		
		//회원가입시간
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String memJoinDate = now.format(formatter);
		
		//비밀번호 키 스트레칭 및 암호화
		for(int i=0; i<10000; i++) {
			memPass = sha256(memPass);
			System.out.println(memPass);
		}

		String sql = "insert into member values(?,?,?,?,?)" ;
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, memID);
		pstmt.setString(2, memPass); //바인딩되는 패스워드 sha256+키스트레칭
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

	
	
	
	
	
	
	
	
	
	
	
	