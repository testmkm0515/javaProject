<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>객체 바인딩 EL 표현</title>
	</head>
	<body>
		<%
			request.setCharacterEncoding("utf-8");
		%>
		id : ${mem.id }<br> <!-- 객체 필드의 getter 호출 -->
		pwd : ${mem.pwd }<br>
		name : ${mem.name }<br>
		email : ${mem.email }<br>		
	</body>
</html>