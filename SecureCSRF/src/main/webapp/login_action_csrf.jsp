<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

request.setCharacterEncoding("utf-8"); // post방식 한글처리
String id = request.getParameter("id");
String pw = request.getParameter("pass");
System.out.println(id);
System.out.println(pw);
try
{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String db_address = "jdbc:oracle:thin:@localhost:1521/xepdb1";
	String db_username = "sql_select";
	String db_pwd = "1234";
	Connection connection = DriverManager.getConnection(db_address, db_username, db_pwd);
    
    request.setCharacterEncoding("UTF-8");
    
    String insertQuery = "SELECT * FROM member WHERE memid='" + id +"' and mempwd='"+pw+"'";
    
    PreparedStatement psmt = connection.prepareStatement(insertQuery);
    
    ResultSet result = psmt.executeQuery();
    
    if(result.next()){ //로그인 성공
    	String dbid = result.getString("memid");
    	String dbpwd = result.getString("mempwd");
    	String dbname = result.getString("memname");
		//로그인증명을 위한 session 생성-특정 클라이언트와의 연결 확립(session)
		session.setAttribute("S_ID", dbid);
		session.setAttribute("S_name", dbname);
		session.setAttribute("CSRF_TOKEN",UUID.randomUUID().toString());//변조를 방지하기 위해 임의값으로 파라미터를 하나 더 전송
		//위 세션 속성은 로그인 성공하지 않은경우 저장되지 않음
    }
	response.sendRedirect("post_list.jsp"); //로그인 요청 후 이동
}catch (Exception ex)
{	ex.printStackTrace();
    out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());
}
%>