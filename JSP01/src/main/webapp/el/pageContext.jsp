<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>pageContext 내장객체</title>
	</head>
	<body>
		<!-- 로그인 페이지로 이동하는 여러가지 방법 -->
		<a href="http://localhost:8080/JSP01/el/login.jsp">로그인1</a><br>
		<a href="/JSP01/el/login.jsp">로그인2</a><br>
		<a href="<%=request.getContextPath()%>/el/login.jsp">로그인3</a><br>
		<a href="${pageContext.request.contextPath}/el/login.jsp">로그인4</a><br>
		
	</body>
</html>