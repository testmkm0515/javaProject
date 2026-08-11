package jdbc.update;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import jdbc.DBConn;

public class CRUDTestDelete {

	public static void main(String[] args) {
		//도서테이블에 레코드 insert
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		DBConn dbCon = new DBConn();
		String bookNo, bookTitle, bookAuthor, bookDate, pubNo;
		int bookPrice, bookStock;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			con = dbCon.getConnection();
			// 삭제 구문 미완성 쿼리 구성
			String sql = "delete book where bookNo = ?"; 
			pstmt = con.prepareStatement(sql);

			//사용자로부터 데이터 입력 받기
			System.out.print("삭제할 도서의 도서번호 입력 : ");
			bookNo = sc.nextLine();
		
			
			//데이터 바인딩
			pstmt.setString(1,bookNo);			
			int tmpRes = pstmt.executeUpdate(); //바인딩까지 완료된 쿼리를 실행
			
			if(tmpRes == 1) System.out.println("도서정보 삭제 성공");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		////////////////////////////////////////////////////////////////////////////
		// db에 저장 완료 후 확인용 출력
		try {
		// 쿼리
		String query = "SELECT * FROM book";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query); 
		
		System.out.println("--------------전체 도서 정보 조회 -------------");
		System.out.println("도서번호 \t 도서명 \t\t\t\t 저자 \t\t 가격 \t\t 발행일  \t 재고 \t 출판사 번호");
		while(rs.next()) {			
			bookNo = rs.getString(1);
			bookTitle = rs.getString(2);
			bookAuthor = rs.getString(3);
			bookPrice = rs.getInt(4);
			Date bookDate1 = rs.getDate(5);
			bookStock = rs.getInt(6);
			pubNo = rs.getString(7);
			
			//한행씩 출력
			System.out.format("%-10s\t %-20s\t %-10s %6d %13s \t%3d %10s\n", 
					bookNo, bookTitle, bookAuthor, bookPrice, bookDate1, bookStock, pubNo);				
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
