package encryption.sec03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import encryption.sec02.DBConn;

public class StudentInjectMain {
	public static void main(String[] args) {
		//DB 연결
		DBConn dbCon = new DBConn();
		Connection con = dbCon.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);

		//java.sql 패키지의 모든 객체는 오류를 던지기 때문에 사용측에서는 예외처리가 반드시 필요함
		try {
			System.out.print("학생 번호 입력 : ");
			String stdNo = sc.nextLine();
			System.out.println(stdNo);

			String sql = "select * from student where stdNo='" + stdNo + "'";
			
			System.out.println(sql);
			
			pstmt = con.prepareStatement(sql); 
			//pstmt.setString(1, stdNo);
			rs = pstmt.executeQuery();
			
			//제목 출력
			System.out.println("------------ 학생 정보 조회 -----------------");
			System.out.println("학생번호  \t 학생이름 \t\t\t\t 학년");
			
			//필요내용만 출력 : 모든 컬럼을 select 하지만 사용자에게 전달할 정보만 출력하는 방식으로 프로그램 개발
			//3개의 컬럼만 표현
			while(rs.next()) {
				stdNo = rs.getString(1);
				String stdName = rs.getString(2);
				int stdYear = rs.getInt(3);
				
				//한행씩 출력
				System.out.format("%-10s\t %-20s\t %6d \n",stdNo, stdName, stdYear);
			}
		}catch(Exception e) {
			//e.printStackTrace(); //로그용으로 구성
			//페이지인 경우에는 에러페이지가 전송되도록 구성
			System.out.println("잘못된 구문이 입력되었습니다");
		}
	}
}















