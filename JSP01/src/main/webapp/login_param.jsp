<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>forward 액션 태그</title>
	</head>
	<body>
		<%
			//초기 호출인 경우 파마미터 msg 없음, loginParamResult에 의해 포워딩된 경우는 msg 파라미터 존재
			String msg = request.getParameter("msg");
		
			if(msg != null){
		%>
			<h3><%= msg %></h3>			
		<%
			}
		%>
		
		<form name="frmLogin" method="post" action="loginParamResult.jsp">
			아이디 : <input type="text" id="user_id" name="user_id"><br>
			비밀번호 : <input type="password" name="user_pw"><br>
			<input type="submit" value="로그인"> <input type="reset" value="취소">
		</form>
	</body>
</html>