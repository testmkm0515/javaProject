<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
		//session - 서버측에 저장하는 정보, 현재 연결된 특정 클라이언트와의 연결정보가 저장되는 객체
		//연결되어 있는 동안 객체는 활성화 됨, 특정조건에 만족하지 않으면 객체는 제거됨->클라이언트와의 연결이 종료
		//클라이언트 요청이 들어오면 세션 객체는 생성됨->클라이언트에게 응답시 쿠키에 session id값을 전송함
		//클라이언트 재 요청시에 session id값을 서버측으로 전달해야 함->전달된 session id를 활용 로그인 여부를 어플리케이션은 확인하게 됨
		session.setAttribute("S_ID", dbid);
		session.setAttribute("S_name", dbname);
		//위 세션 속성은 로그인 성공하지 않은경우 저장되지 않음
    }
	response.sendRedirect("post_list.jsp"); //로그인 요청 후 이동
}catch (Exception ex)
{	ex.printStackTrace();
    out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());
}
%>