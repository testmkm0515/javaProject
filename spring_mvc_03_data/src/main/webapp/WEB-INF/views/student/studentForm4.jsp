<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Student Form</title>
	</head>
	<body>
		<h3>학생 정보 등록</h3>

		<form method="post" action="/projectData/student/newStudent6">
			학번 <input type="text" name="no"><br>
			성명 <input type="text" name="name"><br>
			학년 <input type="text" name="year"><br>
			생일 <input type="text" name="birthday"> : 입력형식 yyyy-MM-dd<br>
			<input type="submit" value="등록"> <input type="reset" value="취소">
		</form>


	</body>
</html>