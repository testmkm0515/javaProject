<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>우선순위</title>
	</head>
	<body>
	<%
		session.setAttribute("name","세션");
		application.setAttribute("name","애플리케이션");
		//request.setAttribute("name","리퀘스트");
	%>
		<jsp:forward page="scope-priority-result.jsp"/>
		
	</body>
</html>