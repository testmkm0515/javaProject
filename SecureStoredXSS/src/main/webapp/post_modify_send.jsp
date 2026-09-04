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
	String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
	String user = "SQL_SELECT";
	String pwd = "1234";
    Connection connection = DriverManager.getConnection(url,user,pwd);
    
    request.setCharacterEncoding("UTF-8");
    
 	String writer = request.getParameter("writer");
 	String title = request.getParameter("title");
 	String content = request.getParameter("content");
    
    String num = request.getParameter("num");
    
    String insertQuery = "SELECT * FROM pratice_board WHERE num=" + num;
    
 	PreparedStatement psmt = connection.prepareStatement(insertQuery);
 	
 	ResultSet result = psmt.executeQuery();
 	
 	while(result.next())
 	{
        insertQuery = "UPDATE pratice_board set title=?, writer=?, content=? WHERE num=" + num;
 	    
 	    psmt = connection.prepareStatement(insertQuery);
        
        psmt.setString(1, title);
        psmt.setString(2, writer);
        psmt.setString(3, content);
        
        psmt.executeUpdate();
        
        response.sendRedirect("post_list.jsp");
 	}
}
catch (Exception ex)
{
	out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());
}
%>