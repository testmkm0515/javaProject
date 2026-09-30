<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 다운로드</title>
</head>
<body>
	다운로드 파일 LIST <br>	
	<c:forEach var="file" items="${filelist}">
	${file} <a href="<c:url value='/fileDownload/${file}'/>">다운로드</a> <br>	
	</c:forEach>

	
	<br><br>
	<a href = "<c:url value='/'/>"> 메인으로 이동</a>
</body>
</html>