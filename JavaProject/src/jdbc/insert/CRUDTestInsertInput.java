package jdbc.insert;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import jdbc.DBConn;

public class CRUDTestInsertInput {

	public static void main(String[] args) {
		//도서테이블에 레코드 insert
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		DBConn dbCon = new DBConn();
		String bookNo, bookTitle, bookAuthor, bookDate, pubNo;
		int bookPrice, bookStock;
		
		try {
			con = dbCon.getConnection();
			stmt = con.createStatement();
			
			
			bookNo = "98";
			bookTitle = "자바개정판2";
			bookAuthor = "김바로";
			bookPrice = 20000;
			bookDate = "2025-01-01";
			bookStock = 5;
			pubNo = "2";			

			//statement객체는 매번 전처리(형식검사를 진행 함 - 완성된 쿼리구문을 전달해야 함) : 런타임
			//변수와 문자열 결합이 복잡함, 자바 보안 측면에서 취약한 쿼리 결합으로 분류됨
			//String sql = "insert into book values('"+bookNo+"','"+bookTitle+"','"+bookAuthor+"',"+
			//				bookPrice+",'"+bookDate+"',"+bookStock+",'"+pubNo+"')";
			//int tmpRes = stmt.executeUpdate(sql);
			
			////////////////////////////////////////////////////////////////
			//PreparedStatement 객체 - 복잡한 쿼리 구성의 간결화, 보안측면에서 취약한 쿼리를 배제 시킬 수 있음
			//Statement 객체의 하위 인터페이스, 형식검사를 미리 진행 함(컴파일러) - 쿼리 완성 후 형식검사 진행하지 않음
			//변수 바인딩 진행 : ? 바인딩문자->플레이스홀더 사용 , 인수가 많은 쿼리에 적합
			//처음 한번 전처리 후 다음 사용시에는 전처리 하지 않는다
			
			bookNo = "88";
			//미완성 쿼리구문
			String sql = "insert into book values(?,?,?,?,?,?,?)"; 
			pstmt = con.prepareStatement(sql);
			
			//?의 실제값 적용 : setXXX
			//데이터 바인딩
			pstmt.setString(1,bookNo);
			pstmt.setString(2,bookTitle);
			pstmt.setString(3,bookAuthor);
			pstmt.setInt(4, bookPrice);
			pstmt.setString(5, bookDate);
			pstmt.setInt(6, bookStock);
			pstmt.setString(7, pubNo);
			
			int tmpRes = pstmt.executeUpdate(); //바인딩까지 완료된 쿼리를 실행
			
			if(tmpRes == 1) System.out.println("인서트 성공");
		
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
