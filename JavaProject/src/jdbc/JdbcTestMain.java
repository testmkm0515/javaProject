package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement; //쿼리 구문 저장공간 생성 (Connection 객체 통해 생성)
import java.sql.ResultSet; //select 진행 후 반환되는 테이블 결과를 받을 객체

public class JdbcTestMain {

	public static void main(String[] args) {
		// Connection 사용자 정의 클래스 활용 db 접속 테스트
		DBConn dbCon = new DBConn();
		Connection con = dbCon.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		if(con==null) { // db 접속 실패
			System.out.println("db 생성 실패");
		}else { // db 접속 성공 시 도서 정보 조회
			System.out.println("db 생성 성공");
			
			try {
			// 쿼리
			String query = "SELECT * FROM book";
			
			// 쿼리를 저장하고 전달, 실행 담당 객체를 하나 생성 : Statement 객체 생성
			stmt = con.createStatement();
			//쿼리를 dbms에 전달, 실행요청, 실행된 결과반환 : 반환이 성공하면 조회된 결과가 rs의 참조로 반환
			rs = stmt.executeQuery(query); //select 구문일때 사용하는 메서드, ResultSet 반환
			
			System.out.println("--------------전체 도서 정보 조회 -------------");
			System.out.println("도서번호 \t 도서명 \t\t\t\t 저자 \t\t 가격 \t\t 발행일  \t 재고 \t 출판사 번호");
			
			//ResultSet 객체 활용 포인터 이동해가면서 각 속성 값 추출
			//getXXX(속성번호) : XXX -> String, Int, Date
			while(rs.next()) {
				//각 메소드가 속성값 1개를 추출, 전체 메소드를 실행하면 1개 레코드의 각 속성 데이터가 변수에 저장됨
				String bookNo = rs.getString(1);
				String bookName = rs.getString(2);
				String bookAuthor = rs.getString(3);
				int bookPrice = rs.getInt(4);
				Date bookDate = rs.getDate(5);
				int bookStock = rs.getInt(6);
				String pubNo = rs.getString(7);
				
				//한행씩 출력
				System.out.format("%-10s\t %-20s\t %-10s %6d %13s \t%3d %10s\n", 
						bookNo, bookName, bookAuthor, bookPrice, bookDate, bookStock, pubNo);				
			}
				rs.close();
				stmt.close();
				con.close();
			}catch(Exception e) {
				System.out.println("오류발생");
				e.printStackTrace();
			}
		}

	}

}











