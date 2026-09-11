<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"  language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="/project/newView">newView 페이지 1</a> <br><br>
<a href="<c:url value='/newView'/>">newView 페이지 2</a> <br><br>
<img src="/project/resources/image/apple.png"><br><br>
<img src="<c:url value='/resources/image/apple.png'/>"><br><br>
</body>
</html>
