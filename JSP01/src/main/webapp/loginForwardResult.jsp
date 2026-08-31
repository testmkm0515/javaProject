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
		request.setCharacterEncoding("utf-8");
		String user_id=request.getParameter("user_id");
		
		if(user_id.length()==0){ //id가 입력되지 않았으므로 포워딩 진행(id 입력으로 페이지 전환)
			//포워딩 액션태그
			%>
			<jsp:forward page="login_forward.jsp"/>
	<%		
		}
	%>
		<h3>환영합니다 <%= user_id %>님</h3>
		
	</body>
</html>