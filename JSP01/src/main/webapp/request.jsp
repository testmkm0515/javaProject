<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>클라이언트 요청 정보 확인</title>
	</head>
	<body>
		<%
			//내장 객체 : out (톰캣 버퍼쪽으로 출력(응답)데이터를 전송하는 객체)
			//request 객체 : 내장객체 생성없이 사용 가능
			out.println("서버 : " + request.getServerName() + "<br>");
			out.println("포트번호 : " + request.getServerPort() + "<br>");
			out.println("요청방식 : " + request.getMethod() + "<br>");
			out.println("프로토콜 : " + request.getProtocol() + "<br>");
			out.println("URL : " + request.getRequestURL() + "<br>");
			out.println("URI : " + request.getRequestURI() + "<br>");
			out.println("ContextPath : " + request.getContextPath() + "<br>");
			out.println("ServeltPath : " + request.getServletPath() + "<br>");
		%>
	</body>
</html>