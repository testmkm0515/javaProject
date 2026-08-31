<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력내용 확인</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	%>	
	
	아이디 : <%= request.getParameter("id") %> <br>
	비밀번호 : <%= request.getParameter("pwd") %> <br>
	이름 : <%= request.getParameter("name") %> <br>
	이메일 : <%= request.getParameter("email") %> <br>
</body>
</html>