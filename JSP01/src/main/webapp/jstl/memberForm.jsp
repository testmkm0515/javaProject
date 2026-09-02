<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보입력</title>
</head>
<body>
	<form name="frmMember" method="post" action="newMemberOk.jsp">
		아이디: <input type="text" name="id"><br>
		비밀번호: <input type="password" name="pwd"><br>
		이름: <input type="text" name="name"><br>
		이메일: <input type="text" name="email"><br>
		<input type="submit" value="확인">
	</form>
</body>
</html>