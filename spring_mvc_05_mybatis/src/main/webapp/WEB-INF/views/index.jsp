<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품관리</title>
</head>
<body>
	<h3>MyBatis 사용 DB 연동</h3>
	<h4>상품 관리 시스템 <img src="<c:url value='/resources/image/apple.png'/>"/></h4>
	<br>
	<a href="<c:url value='/product/listAllProduct'/>">전체상품조회</a><br>
	<a href="<c:url value='/product/newProductForm'/>">상품 등록</a><br>
	<br><br>
	
	<h4>Ajax 연습</h4>
	<a href="<c:url value='/loginForm'/>">로그인</a>
	<a href="<c:url value='/loginForm2'/>">로그인</a>
	
	
</body>
</html>