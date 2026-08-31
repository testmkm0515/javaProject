<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>    
<jsp:useBean id="member" class="bean.MemberBean" scope="page">
	<jsp:setProperty property="*"  name="member"/>
</jsp:useBean>     
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>EL 표현어</title>
	</head>
	<body>
		<h3>Bean 속성 값 출력(EL 표현어)</h3>
		아이디 : ${member.id} <br>
		비밀번호 : ${member.pwd} <br>
		이름 : ${member.name} <br>
		이메일 : ${member.email} <br>
		
	</body>
</html>