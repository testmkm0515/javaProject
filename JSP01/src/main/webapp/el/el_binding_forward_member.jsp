<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.MemberBean" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>객체 바인딩후 포워딩</title>
	</head>
	<body>
	<%
		MemberBean mem = new MemberBean("lee","1234","이몽룡","lee@abc.com");
		//바인딩
		request.setAttribute("mem", mem);	
	%>
	<jsp:forward page="el_binding_forward_member_result.jsp"/>
		
	</body>
</html>