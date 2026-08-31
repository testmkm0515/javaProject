<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>For 반복문</title>
	</head>
	<body>
		<%
			int dan = Integer.parseInt(request.getParameter("dan"));
		%>
		
		<h3><%=dan%>단</h3>
		<table border="1">
		<%for(int i=1;i<=9;i++){%>
		
			<tr><td><%=dan%>*<%=i%>=<%=dan*i %></td></tr>

		<%} %>		
		</table>
		
	</body>
</html>