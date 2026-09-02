<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ArrayList JSTL forEch 표현</title>
	</head>
	<body>
		<table border=1 align="center">
			<tr align="center" bgcolor="#99ccff">
				<td width="20%"><b>아이디</b></td>
				<td width="20%"><b>비밀번호</b></td>
				<td width="20%"><b>이름</b></td>
				<td width="20%"><b>이메일</b></td>
			</tr>
			<c:forEach var="data" items="${memberList}">
				<tr align="center">
					<td>${data.id}</td>
					<td>${data.pwd}</td>
					<td>${data.name}</td>
					<td>${data.email}</td>
				</tr>
			</c:forEach>		
		</table>
	</body>
</html>