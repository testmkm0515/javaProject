<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	String answer;
%>   
<%--아래 html태그는 브라우저에 의해 해석 되지 않음 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>요청에 대한 응답처리</title>
	</head>
	<body>
		<%
			request.setCharacterEncoding("UTF-8");
		
			answer = request.getParameter("answer");
			
			if(answer.equals("서울")){
				response.sendRedirect("pass.jsp");
			}else{
				response.sendRedirect("fail.jsp");
			}
		%>		
	</body>
</html>