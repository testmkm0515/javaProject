package encryption.sec02;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MemberJoinMD5 {
	public static String md5(String message) {
		String encData = "";
		try {
		//getInstance("암호화알고리즘") - 해당 알고리즘 객체 반환
		MessageDigest md = MessageDigest.getInstance("MD5");
		//알고리즘을 활용 해시값을 반환받으려면 문자열이 아닌 byte타입의 배열로 전달을 해야 함
		byte[] bytes = message.getBytes();
		md.update(bytes); //md4 인스턴스에 해시로 변환할 byte배열이 전달됨
		byte[] digest = md.digest(); //변환된 해시값이 byte 배열에 저장되어 있음->비밀번호는 문자열이어야 하므로 문자열로 변환
		
		for(int i=0; i<digest.length; i++) {
			encData += Integer.toHexString(digest[i] & 0xff); //16진수 변환 후 문자열로 변환 표현되는 비밀번호 문자 범위 0~f까지
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return encData;
	}
	
	public static void main(String[] args) {
	//취약한 패스워드 저장 1 : MD5 패스워드 해싱
	DBConn dbCon = new DBConn();
	Connection con = dbCon.getConnection();
	PreparedStatement pstmt = null;
	
	Scanner sc = new Scanner(System.in);
	
	try {
		System.out.print("ID 입력 : ");
		String memID = sc.nextLine();
		System.out.print("비밀번호 입력 : ");
		String memPass = md5(sc.nextLine());
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

	
	
	
	
	
	
	
	
	
	
	
	