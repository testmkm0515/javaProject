<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>from param 확인</title>
</head>
<body>
	<p> command 객체는 자동으로 model에 포함되어 view로 전송됨<br>
		arrt의 name은 command 객체 변수명을 활용</p>
	학번 : ${studentInfo.no } <br>
	학년 : ${studentInfo.year } <br>
	이름 : ${studentInfo.name } <br>
</body>
</html>