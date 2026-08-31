<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	String name = "홍길동";
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Jsp Include</title>
	</head>
	<body>
		<!-- top -->
		이 부분에 top.jsp의 내용이 포함됨<p>
		<%--<%@ include file = "top.jsp" %>--%>
		<%@ include file = "top2.jsp" %>
		<hr>
		<!-- 본문 -->
		이 부분은 include.jsp의 내용입니다<p>
		include 지시어를 활용하면 포함되어지는 파일들의 코드를 복사해서 붙여넣기가 진행됨<p>
		실행은 include 요청한 파일에서 실행이 이루어 짐
		<hr>
		<!-- bottom -->
		이 부분에 bottom.jsp의 내용이 포함됨, 오류 발생했던 name변수의 선언 및 초기화는 다른 파일에서 선언 및 초기화 진행<p>
		<%--<%@ include file= "bottom.jsp" %>--%>
		<%@ include file= "bottom2.jsp" %>
		
	</body>
</html>