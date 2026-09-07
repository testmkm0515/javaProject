<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

try
{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String db_address = "jdbc:oracle:thin:@localhost:1521/xepdb1";
	String db_username = "sql_select";
	String db_pwd = "1234";
    Connection connection = DriverManager.getConnection(db_address, db_username, db_pwd);
    String S_NAME = (String)session.getAttribute("S_name");
    String S_csrf = (String)session.getAttribute("CSRF_TOKEN");
    request.setCharacterEncoding("UTF-8");
    
 	String writer = request.getParameter("writer");
 	String title = request.getParameter("title");
 	String content = request.getParameter("content");
 	System.out.println(writer);
    String num = request.getParameter("num");
    String csrf_token = request.getParameter("csrfToken");
    
	if(S_NAME.equals(writer) && S_csrf.equals(csrf_token)){//공격자 csrf 토큰과 일반 사용자 csrf 토큰이 다르기 때문에 공격자에 의해 변조되기는 불가능 함
    
 		PreparedStatement psmt;
        String insertQuery = "UPDATE pratice_board set title=?, writer=?, content=? WHERE num=" + num;
 	    System.out.println(insertQuery);
 	    psmt = connection.prepareStatement(insertQuery);
        
        psmt.setString(1, title);
        psmt.setString(2, S_NAME);
        psmt.setString(3, content);
        
        psmt.executeUpdate();
	}
        response.sendRedirect("post_list.jsp");

}
catch (Exception ex)
{	ex.printStackTrace();
	out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());
}
%>