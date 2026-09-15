<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>index 페이지</title>
	</head>
	<body>
		<div style="text-align:center;">
		<h3>Spring JDBC 연결 예제</h3><br>
		
		<a href="/jdbcProject/member/memberSelect">회원 조회</a><br>
		<a href="<c:url value='/member/memberSelect'/>">회원조회</a><br>
		</div>
</body>
</html>