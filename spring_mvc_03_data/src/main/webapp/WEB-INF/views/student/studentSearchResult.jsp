<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색결과</title>
</head>
<body>
	<table border="1">
		<tr><th>학번</th><th>성명</th><th>학년</th></tr>
		<c:forEach var="std" items="${stdList}" >
			<tr>
				<td>${std.no }</td>
				<td>${std.name }</td>
				<td>${std.year }</td>
			</tr>
		</c:forEach>
	
	</table>

</body>
</html>