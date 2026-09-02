<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:url var="url1" value="/jstl/urlTestRes.jsp">
	<c:param name="id" value="hong"/> <%-- ?id=hong --%>
	<c:param name="pwd" value="1234"/><%-- ?id=hong&pwd=1234 --%>
	<c:param name="name" value="홍길동"/>
	<c:param name="email" value="hong@test.com"/><%-- /JSP01/jstl/urlTestRes.jsp?id=hong&pwd=1234&name=홍길동&email=hong@test.com --%>
</c:url>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>c:url 태그 예시</title>
	</head>
	<body>
		<a href="${url1}">회원정보출력</a>
	</body>
</html>