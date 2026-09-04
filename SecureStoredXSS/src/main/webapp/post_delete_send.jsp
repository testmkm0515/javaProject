<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
try
{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
	String user = "SQL_SELECT";
	String pwd = "1234";
    Connection connection = DriverManager.getConnection(url,user,pwd);
    
    request.setCharacterEncoding("UTF-8");
    
    String num = request.getParameter("num");
    
    String insertQuery = "DELETE FROM pratice_board WHERE num=" + num;
    
 	PreparedStatement psmt = connection.prepareStatement(insertQuery);

    psmt.executeUpdate();
 	
    response.sendRedirect("post_list.jsp");
}
catch (Exception ex)
{
	out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());
}
%>