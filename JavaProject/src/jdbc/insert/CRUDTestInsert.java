package jdbc.insert;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

import jdbc.DBConn;

public class CRUDTestInsert {

	public static void main(String[] args) {
		//도서테이블에 레코드 insert
		Connection con = null;
		Statement stmt = null;
		
		DBConn dbCon = new DBConn();
		
		try {
			con = dbCon.getConnection();
			stmt = con.createStatement();
			
			//insert 진행, 삽입 데이터가 상수(정해진 값)
			String sql = "insert into book values('1000','자바개정판','김바로',18000,'2025-01-15',5,'2')";
			//statement 객체는 매번 형식검사(전처리)를 진행함
			//stmt.executeUpdate(sql); //insert, update, delete 문에 사용할 수 있음
			int tmpRes = stmt.executeUpdate(sql);
			//tmpRes는 db가 수행한 질의 수를 반환함
			if(tmpRes == 1) System.out.println("인서트 성공");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		// db에 저장 완료 후 확인용 출력
		try {
		// 쿼리
		String query = "SELECT * FROM book";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query); 
		
		System.out.println("--------------전체 도서 정보 조회 -------------");
		System.out.println("도서번호 \t 도서명 \t\t\t\t 저자 \t\t 가격 \t\t 발행일  \t 재고 \t 출판사 번호");
		while(rs.next()) {			
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












