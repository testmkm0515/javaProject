<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	String answer;
%>   
<%--아래 html태그는 브라우저에 의해 해석 되지 않음 헤더통해 302 상태 확인 후 바로 재요청
	jsp태그만 있는 jsp 파일 구성 가능
--%>

<%
	request.setCharacterEncoding("UTF-8");

	answer = request.getParameter("answer");
	
	if(answer.equals("서울")){
		response.sendRedirect("pass.jsp");
	}else{
		response.sendRedirect("fail.jsp");
	}
%>		
