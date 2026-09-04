package encryption.sec02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;



public class MemberLoginMD5 {
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
			//사용자가 입력한 비밀번호를 md5 함수를 통해 해시값으로 변경 후 쿼리에 활용되도록 수정
			String memPass = MemberJoinMD5.md5(sc.nextLine());	
			System.out.println(memPass);
			//select 쿼리문 작성 - 취약한 페이지
			String sql = "select * from member where memID = '" + memID + "'" +  "and memPWD = '" + memPass + "'";	
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			//회원가입을 진행할 때 해시알고리즘으로 비밀번호를 암호화 했음
			//로그인 진행시에는 로그인시 입력된 비밀번호를 회원가입시 사용했던 동일한 알고리즘으로 해시값을 구성해서
			//저장된 비밀번호와 매칭해야 됨
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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	