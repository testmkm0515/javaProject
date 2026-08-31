<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
	String msg = "아이디를 입력하지 않았습니다. 아이디 입력하세요";
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>param 포함 포워드액션태그</title>
	</head>
	<body>
		<%
			request.setCharacterEncoding("utf-8");
			String user_id = request.getParameter("user_id");
			
			if(user_id.length()==0){
		%>
			<jsp:forward page="login_param.jsp">
				<jsp:param name="msg" value="<%=msg %>"/>
			</jsp:forward>
		<%		
			}
		%>
		<h3>환영합니다 <%= user_id %>님</h3>
		
	</body>
</html>