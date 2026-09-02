<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"
    %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>예외발생</title>
	</head>
	<body>
		===================================================<br>
		<h3><%=exception.toString()  %></h3>
		===================================================<br>
		<h3><%=exception.getMessage()%></h3>
		===================================================<br>
		<% exception.printStackTrace(); //log 기록용%>
		
		
		<h3>입력에 오류가 있습니다 다시 시도하세요</h3>
		<a href='add.html'>다시하기</a>
	</body>
</html>