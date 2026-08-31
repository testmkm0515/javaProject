<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	int add(int a, int b){
		return a*b;		
 	}

	int x = 20, y = 10;
	//y = 20;
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>표현식예제</title>
	</head>
	
	<body>
		<!-- 표현식에 포함 가능한 연산은 변수, 연산식, 메소드호출 등 -->
		x = <%= x %> <br>
		y = <%= y %> <br>
		add(x,y) = <%= add(x,y) %> 
		
	</body>
</html>