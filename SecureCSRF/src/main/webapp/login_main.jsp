<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h3>로그인(session)</h3>
   <form method="post" action="login_action_csrf.jsp">
   <table>
      <tr><th>아이디</th>
      		<td><input type="text" name="id"/></td></tr>
      <th>패스워드</th>
      		<td><input type="password" name="pass"/></td></tr>      		
      <tr><td colspan="2"><input type="submit" value="로그인"/></td></tr>
   </table>
   </form>
</body>
</html>