<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 영역이 page이므로 변수처럼 사용 가능 value에 el 표현 사용가능 -->
<c:set var="id" value="hong" scope="page"/>
<c:set var="pwd" value="1234" scope="page"/>
<c:set var="name" value="${'홍길동'}" scope="page"/>
<c:set var="age" value="${20}" scope="page"/>  

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>c:set 활용 예시</title>
	</head>
	<body>
		${id}<br>
		${pwd}<br>
		${name}<br>
		${age}<br>		
	</body>
</html>