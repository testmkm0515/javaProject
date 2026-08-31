<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		JSP 표현식 : <%= 100 %> <br>
		JSP EL 	   : ${100 } <br>
		${3.14 }<br>
		${"홍길동" }<br>
		${true }<br>
		${true and true}<br>
		${true && true}<br>
		${10 + 1}<br>
		${100 % 9 }<br>
		${100 mod 9}<br>
		<%-- ${"hello" + "world" }<br> //문자열 결합 EL에서 불가능, jsp 표현식에서는 가능ㅋ --%>
		<%="hello" + "world" %><br>
		
	</body>
</html>