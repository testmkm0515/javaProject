<%@page import="java.sql.Timestamp" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.PreparedStatement" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- 게시글을 저장하는 로직 클라이언트에게 응답할 내용은 없음 
	 저장 종료 후에 게시글 목록보기로 클라이언트재요청 신호를 보냄
--%>
<% 
	try { 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String user = "SQL_SELECT";
		String pwd = "1234";			
		Connection con = DriverManager.getConnection(url,user,pwd);	
		
		request.setCharacterEncoding("UTF-8");
		
		//글 작성일
		Timestamp today_date = new Timestamp(System.currentTimeMillis());
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		int num=0;
		
		//저장된 게시글의 글번호중 가장 큰값을 추출 +1 한 값을 현재글의 번호
		String query = "SELECT MAX(num) FROM pratice_board";
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet result = pstmt.executeQuery();
		
		while(result.next()){
			num = result.getInt("MAX(num)") + 1;
		}
		//게시글 db 저장 코드
		String insertQuery = "INSERT INTO pratice_board(num, title, writer, content, regdate) VALUES (?,?,?,?,?)";
	
		pstmt = con.prepareStatement(insertQuery);
		pstmt.setInt(1, num);
		pstmt.setString(2,title);
		pstmt.setString(3,writer);
		pstmt.setString(4,content);
		pstmt.setTimestamp(5, today_date);	
		pstmt.executeUpdate();
		
		//db 저장 후 저장된 게시글이 반영된 목록보기 재요청 신호 보냄
		response.sendRedirect("post_list.jsp");
	} catch (Exception ex){ 		
		out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());
	}
%>













