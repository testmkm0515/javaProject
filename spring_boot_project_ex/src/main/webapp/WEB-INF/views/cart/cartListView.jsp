<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>장바구니 목록</title>
		<c:import url="/WEB-INF/views/layout/head.jsp" />		   	
        <script src="<c:url value='/js/cartListView.js' />"></script>        
	</head>
	<body>
		<div id="wrap">
        	<!--  top -->         
        	<c:import url="/WEB-INF/views/layout/top.jsp" />
		<section>		
		<h3>장바구니 목록</h3>
			<form method="post" action="<c:url value='/product/orderForm'/>">
				<table border="1" width="900">
					<tr>
						<td><input type="checkbox" id="allCheck" name="allCheck"> 전체 선택</td>
						<td colspan="5" align="left">장바구니에서 상품 삭제를 원하시면 체크박스를 선택하시고 [삭제] 버튼을 눌러 주세요</td>
					</tr>
					<tr>
						<th><input type="button" id="deleteCartBtn" value="삭제"></th>
						<th>사진</th>
						<th>상품명</th>
						<th>가격</th>
						<th>주문수량</th>
						<th>구매예정금액</th>						
					</tr>
					<c:forEach var="prd" items="${cartList }">
			            <tr>
			              <td><input type="checkbox" class="chkDelete" value="${prd.cartNo}"></td>
			               <td><img src="<c:url value='/prd_images/${prd.prdImg}' />" width="30" height="20"></td>			              
			               <td>${prd.prdName }</td>
			               <td  align="right">
			               		<span class="price" data-price=${prd.prdPrice }>
			               			<fmt:formatNumber value="${prd.prdPrice }" pattern="#,###" />
			               		</span> 원</td>
			               <td><input type="text" class="cartQty"  name="cartQty" value="${prd.cartQty }" size="1">
			               			<input type="hidden" name="cartNo" value="${prd.cartNo}">
			               			<%-- <input type="hidden" name="memId" value="${prd.memId}"> --%>
			               </td>
			               <td align="right">
						<!--금액 계산 로직 추가-->
			               		<span class="amount" data-amount="${prd.prdPrice * prd.cartQty}">
			               			<c:set var="amount" value="${prd.prdPrice * prd.cartQty}"/> 
			               			<c:set var="sum" value="${sum+amount}"/>
			               			<fmt:formatNumber value="${amount}" pattern="#,###"/>
			               		</span> 원
			               </td>   
			            </tr>
			         </c:forEach>
			         <tr><td colspan="5">총구매예정금액</td>
			         		<td align="right">
			         			<span id="total">
			         				<!--총 구매예정금액 표시-->
			         				<fmt:formatNumber value="${sum}" pattern="#,###"/> 	
			         			</span> 원</td>
			         </tr>
				</table><br><br>
				
				<input type="submit" value="주문하기">
			</form>
		</section> 
		
		<!--  bottom -->         
        	<c:import url="/WEB-INF/views/layout/bottom.jsp" />
      </div>
	</body>
</html>