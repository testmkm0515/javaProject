<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메소드 정의</title>
	</head>
	<body>
	<h2>선언문 - 메소드 정의</h2>
	
	<%!
		String id ="abcd";
		//스크립트 릿 에서는 메소드 선언 불가능
		public String getId(){
			return id;
		}
	%>
	id 변수 : <%= id %> <br>
	getId()메소드 호출 결과 : <%= getId() %>
	
		
	</body>
</html>


