<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 결과</title>
</head>
<body>
	다음의 파일을 전송하였습니다 <br>	
	<c:forEach var="file" items="${originalFileNameList}">
	${file} <br>	
	</c:forEach>
	upload 폴더에서 확인하세요
	
	<br><br>
	<a href = "<c:url value='/'/>"> 메인으로 이동</a>
</body>
</html>