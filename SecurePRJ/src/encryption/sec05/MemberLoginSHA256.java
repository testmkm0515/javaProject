package encryption.sec05;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

//로그인 시 salt값은 db에 저장되어 있는 상태임
//회원정보와 동일 테이블에 저장되어 있으면 취약한 정보저장임 (단, 연습용이어서 동일 테이블에 저장했음)
//로그인 시 에는 해시기능 메소드만 필요함(개발자는 회원가입시 진행한 스트레칭 수는 개발자는 알고 있음)
public class MemberLoginSHA256 {
	//비밀번호 해싱 : 키스트레칭 + salt
	public static String sha256(String password, String salt) throws Exception{ //스트레칭도 동시 실행되도록 구성
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		for (int i=0; i<10; i++) {
			password = password+salt;		
			md.update(password.getBytes());
			password = bytesToHex(md.digest()); //byte형 배열을 반환 -> 문자열로 변환 후 반복에서 재 사용
		}
		return password;
	}
	//byte형 배열 문자열로 변경 결합 (16진수로 변경 후 결합) -> 16진수로 변경하는 이유는 표현되는 값의 범위가 넓어지도록 16진수로 변경
	public static String bytesToHex(byte[] bytes) {
		StringBuilder builder = new StringBuilder();
		for(byte b : bytes) {
			builder.append(String.format("%02x",b));
		}
		return builder.toString();
	}
	
	public static void main(String[] args) {
		DBConn dbCon = new DBConn();
		Connection con = dbCon.getConnection();
		PreparedStatement pstmt = null;		
		
		ResultSet rs = null; //select 구문		
		Scanner sc = new Scanner(System.in);
		String dbPwd = null;
		String dbSalt = null;
		
		try {
			System.out.print("ID 입력 : ");
			String memID = sc.nextLine();
			System.out.print("비밀번호 입력 : ");
			String memPass = sc.nextLine();	
			System.out.println(memPass);			

			//회원id는 기본키로 설정되므로 유일 함
			//패스워드와의 매칭은 salt가 있어야 함
			//id에 매칭되는 회원정보를 select 한 후에 salt값을 활용 비밀번호 해시값을 계산한 후 db 비밀번호와 매칭 테스트
			String sql = "select * from member where memID = '" + memID + "'" ;	
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			//회원가입시 중복 아이디는 허용하지 않음
			//위 쿼리의 결과는 레코드가 1개거나 아니면 없거나
			if(rs.next()) {
				dbPwd = rs.getString(2);
				dbSalt = rs.getString(6);
				String hasPass = sha256(memPass, dbSalt);
				if(dbPwd.equals(hasPass)) {
					System.out.println("로그인 성공");
				}else {
					System.out.println("로그인 실패"); //id는 존재하는데 비밀번호가 다름
				}
				
			}else {
				System.out.println("로그인 실패-해당 회원정보가 없습니다(id 부재)");//id가 존재하지 않는경우
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	