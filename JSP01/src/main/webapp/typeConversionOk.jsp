<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>형변환</title>
	</head>
	<body>
		<%! int width, height; %>
		<%
			width = Integer.parseInt(request.getParameter("width")); //파라미터 값은 문자열
			height = Integer.parseInt(request.getParameter("height"));
		%>		
		사각형 넓이 : <%= width*height %>
	</body>
</html>