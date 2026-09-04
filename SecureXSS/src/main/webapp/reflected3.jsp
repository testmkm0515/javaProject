<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>반사형코드</title>
	</head>
	<body>
	<!-- 
		아래 코드는 클라이언트가 요청 신호를 보냈을 때 검색어를 추출해서 검색을 진행한 후 그 결과를
		요청한 페이지로 전송하는 코드
	 -->
	 <%
	 	String keyword;
	 	request.setCharacterEncoding("utf-8");
	 	keyword = request.getParameter("keyword");
	 	// keyword통한 검색을 진행 검색 결과 포함해서 응답을 진행, 요청한 페이지로 응답결과를 보냄
	 	// 클라이언트단 포워딩인 redirect 진행
	 	String keywordRes = "";
	 	response.sendRedirect("main3.jsp?keyword="+keyword+"&keywordRes="+keywordRes);
	 %>		
	</body>
</html>