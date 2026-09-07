<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
// 세션속성값 전체 삭제
session.invalidate();
// 로그아웃 메시지 출력 main.jsp 이동
%>
<script type="text/javascript">
	alert("로그아웃");
	location.href="main.html";
</script>
</body>
</html>