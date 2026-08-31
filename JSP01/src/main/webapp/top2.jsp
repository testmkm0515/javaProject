<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- page 지시어 통해서 import 가능  --%>
<%@ page import="java.util.*" %>  
 <%
 	  Date date = new Date(); //Data 객체 생성
 %>
		<font color="blue" size="3pt">
			<h3>top.jsp 입니다</h3>
			<%=date.toLocaleString() %>
		</font>
