<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>상품 상세 조회</title>
		<script src="<c:url value='/js/productDetail.js'/>"></script>
		<c:import url="/WEB-INF/views/layout/head.jsp" />
	</head>
	<body>
		<div id="wrap">
			<!--  top -->         
        	<c:import url="/WEB-INF/views/layout/top.jsp" />
			
			<h3>상품 상세 조회</h3>
			<br><br>
			<!-- 서버측으로 전송되는 form data는 prdNo, cartQty데이터가 서버로 전송됨 -->
			<form method="post" action="<c:url value='/product/insertCart'/>"> 
				<table border="1" width="900">
						<tr><td rowspan="10"><img src="<c:url value='/prd_images/${prd.prdImg}'/>" width="300" height="250"></td></tr>
						<tr><td>상품번호 </td><td>
						<input type="hidden" name="prdNo" value="${prd.prdNo}">
						${prd.prdNo}</td>
						<tr><td>상품명  </td><td>${prd.prdName}</td></tr>
						<tr><td>가격  </td>
							<td><span id="price" data-price="${prd.prdPrice}"><!-- 구매예정금액 계산을 위한 data 설정 -->
									<fmt:formatNumber value="${prd.prdPrice}" pattern="#,###" /></span> 원</td></tr>
						<tr><td>제조회사 </td><td>${prd.prdCompany} </td></tr>
						<tr><td>상품설명 </td><td>${prd.prdDescript} </td></tr>
						<tr><td >상품재고 </td><td id="stock" data-stock="${prd.prdStock}">${prd.prdStock} </td></tr>
						<tr><td>주문수량</td>
							<td>
								<input type="button" id="minusBtn" value="-"> 
								<input type="text" id="cartQty" name="cartQty" value="1"  size="1" readonly> 
								<input type="button" id="plusBtn" value="+">
							</td></tr>
						<tr><td>구매 예정 금액</td>
								<td><span id="amount">
										<fmt:formatNumber value="${prd.prdPrice}" pattern="#,###" /></span> 원
								</td></tr>
						<tr><td colspan="2">
						       <!-- 로그인 하지 않은 경우에는 [로그인] 버튼  -->
						       <c:if test="${empty sessionScope.sid}">
						       		<button><a href="<c:url value='/member/loginForm'/>">로그인</a></button>
							   </c:if>
							   <!-- 로그인 한 경우에는 [주문하기][장바구니] 버튼  -->
						       <c:if test="${not empty sessionScope.sid}">
						       		<input type="submit" id="insertCart" value="장바구니">
						       		<input type="submit" id="insertOrder" value="주문하기">
							   </c:if>
										
						       </td></tr>
					</table>
				</form>	
				
				<br><br>
				<a href="<c:url value='/product/productListCtg/${prd.ctgId}'/>"><button>상품 목록 보기</button></a>
				
				
			 <!--  bottom -->         
        	<c:import url="/WEB-INF/views/layout/bottom.jsp" />
    
		</div>
	</body>
</html>






