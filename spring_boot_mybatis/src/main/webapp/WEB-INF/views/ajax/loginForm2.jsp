<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Ajax 연습 : 로그인폼</title>
		<script type="text/javascript" src="js/jquery-3.7.1.min.js"></script>
		<script type="text/javascript" src="js/login2.js"></script>

	</head>
	<body>
	<!-- 
		form을 통한 submit이 발생하면 새로운 페이지의 요청 의미 
		ajax 통해 비동기 통신을 진행
		ajax는 jQuery 기능을 사용함
	-->
		<h3>로그인</h3>
		<!-- <form id="frmLogin" name="frmLogin" action="<c:url value='/login'/>">-->
		<form id="frmLogin2" name="frmLogin" >
			아이디 : <input type="text" id="user_id" name="user_id"><br>
			비밀번호 : <input type="password" name="user_pw" id="user_pw"><br>
			<input type="submit" value="로그인"> <input type="reset" value="취소">
		</form> <br><br>
	</body>
</html>