<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원정보</title>
	</head>
	<body>
	<table align="center" border="1" >
    <tr align="center" bgcolor="lightgreen">
      <td width="7%" ><b>아이디</b></td>
      <td width="7%" ><b>비밀번호</b></td>
      <td width="7%" ><b>이름</b></td>
      <td width="7%"><b>이메일</b></td>
	</tr>
	<tr align="center">
		<td><c:out value="${param.id}"/></td>
		<td>${param.pwd}</td>
		<td><c:out value="${param.name}"/></td>
		<td><c:out value="${param.email}"/></td>
	</tr>
	</table>
		
	</body>
</html>