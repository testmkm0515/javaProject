<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>c:url 사용</title>
		<link href="<c:url value='/css/index.css'/>" />
		<script type="text/javascript" src="<c:url value='/js/index.js'/>"></script>
	</head>
	<body>
		<img src="/image/apple.png"><!-- 잘못된 경로 : http://localhost:8080/image/apple.png -->
		<img src="../image/apple.png"><!-- 현재 위치에서 상위폴더로 이동 후 image 폴더로 이동 http://localhost:8080/JSP01/image/apple.png -->
		<img src="<c:url value='/image/apple.png'/>">		
		<!-- 현재 위치 상관없이 contextpath 찾아감 맨 앞의 /가 contextpath 다음을 의미 -->
	</body>
</html>