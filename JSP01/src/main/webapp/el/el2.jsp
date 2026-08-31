<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" class="bean.MemberBean" scope="page">
	<jsp:setProperty property="name" value="홍길동" name="member"/>
</jsp:useBean>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		표현식 : <%= member.getName() %><br>
		EL     : ${member.name }<br> <!-- member클래스의 getter 호출 -->
		Member 인스턴스 존재 여부 : ${empty member } <br> <!-- member클래스의 객체 존재 여부 -->
		Member 인스턴스 존재 여부 : ${not empty member } <br> <!-- member클래스의 객체 존재 여부 -->
	</body>
</html>