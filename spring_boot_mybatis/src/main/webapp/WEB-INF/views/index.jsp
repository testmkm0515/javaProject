<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MAIN</title>
</head>
<body>
	INDEX <br>
  
    이미지 경로 : 스프링 부트의 자원 기본 경로는 src/main/resources/static으로 설정되어 있음<br>
    <img src="/image/apple.png"><br>
	<h3>MyBatis 사용 DB 연동</h3>
	<h4>상품 관리 시스템 <img src="<c:url value='/image/apple.png'/>"/></h4>
	<br>
	<a href="<c:url value='/product/listAllProduct'/>">전체상품조회</a><br>
	<a href="<c:url value='/product/newProductForm'/>">상품 등록</a><br>
	<a href="<c:url value='/product/productSearchForm1'/>">상품 검색1</a><br>
	<a href="<c:url value='/product/productSearchForm2'/>">상품 검색2</a><br>
	<a href="<c:url value='/product/productSearchForm3'/>">상품 검색3</a><br>
	<br><br>
	
	<h4>Ajax 연습</h4>
	<a href="<c:url value='/loginForm'/>">로그인</a>
	<a href="<c:url value='/loginForm2'/>">로그인</a>


</body>
</html>