<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>param이 Date 타입인 예시</title>
</head>
<body>
	<p>Date 타입의 data 처리</p>
	학번 : ${student1.no } <br>
	학년 : ${student1.year } <br>
	이름 : ${student1.name } <br>
	생일 : <fmt:formatDate value="${student1.birthday}" pattern="YYYY-MM-dd"/> <br>
</body>
</html>