<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>param EL 내장객체</title>
	</head>
	<body>
	<!-- 
		form 태그를 통해 전달되는 파라미터 자체를 참조하는 내장객체 param
		param.파라미터명 -> 파라미터 value 반환
		request.getParameter(파라미터명) 자바코드와 동일한 역할
	 -->
	 <%
	 	request.setCharacterEncoding("utf-8");
	 %>
	 <!--  표현식 -->
	 <%= request.getParameter("id") %> <br>
	 <!--  el 표현어(내장객체 param) -->
	 ${param.id }<br>
	 ${param.pwd }<br>
	 ${param.name}<br>
	 ${param.email }<br>
		
	</body>
</html>