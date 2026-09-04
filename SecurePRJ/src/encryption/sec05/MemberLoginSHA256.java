package encryption.sec05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;



public class MemberLoginSHA256 {
	public static void main(String[] args) {
		DBConn dbCon = new DBConn();
		Connection con = dbCon.getConnection();
		PreparedStatement pstmt = null;		
		
		ResultSet rs = null; //select 구문
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("ID 입력 : ");
			String memID = sc.nextLine();
			System.out.print("비밀번호 입력 : ");
			String memPass = MemberJoinKeySalt.sha256(sc.nextLine());	
			System.out.println(memPass);
			//select 쿼리문 작성 - 취약한 페이지
			String sql = "select * from member where memID = '" + memID + "'" +  "and memPWD = '" + memPass + "'";	
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			//회원가입시 중복 아이디는 허용하지 않음
			//위 쿼리의 결과는 레코드가 1개거나 아니면 없거나
			if(rs.next()) {
				System.out.println("로그인 되었습니다");
				//웹에서는 로그인 자격증명(session)을 구성하고 쿠키를 통해 자격증명을 클라이언트에게 전달(sessionid)
			}else {
				System.out.println("로그인 실패");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	