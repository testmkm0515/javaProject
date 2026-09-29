<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>주문 완료</title>
		<c:import url="/WEB-INF/views/layout/head.jsp" />		
	</head>
	<body>
		<div id="wrap">
        	<!--  top -->         
        	<c:import url="/WEB-INF/views/layout/top.jsp" />
			<section>		
				<h3>주문 완료</h3>
				${ordNo} 주문이 완료되었습니다<br><br>
				<button><a href="<c:url value='/order/orderListView'/>">주문 목록 보기</a></button>
			</section> 
		
			<!--  bottom -->         
        	<c:import url="/WEB-INF/views/layout/bottom.jsp" />
      </div>
	</body>
</html>