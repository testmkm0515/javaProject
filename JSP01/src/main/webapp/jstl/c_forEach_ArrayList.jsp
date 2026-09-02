<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*, bean.MemberBean"
    pageEncoding="UTF-8"    
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<%
	request.setCharacterEncoding("UTF-8");
%>  

<%
	MemberBean m1 = new MemberBean("son","1234","손흥민","son@test.com");
	MemberBean m2 = new MemberBean("park","1234","박지성","park@test.com");
	ArrayList<MemberBean> memberList = new ArrayList<>();
	memberList.add(m1);
	memberList.add(m2);
	
	request.setAttribute("memberList", memberList);
%>
<jsp:forward page="c_forEach_ArrayList_result.jsp"/>












