<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>상품 상세 정보 조회</title>
		<script>
			function deleteCheck(){
				let answer = confirm("삭제하시겠습니까?");
				if(answer==true){
					location.href="<c:url value='/product/deleteProduct/${dto.prdNo}'/>";
				}
			}
		</script>	
	</head>
	<body>
		 <h3>상품 상세 정보 조회</h3>
	     <table border="1" width="300">
				<tr><td>상품번호</td><td>${dto.prdNo }</td></tr>
				<tr><td>상품명</td><td>${dto.prdName }</td></tr>
				<tr><td>가격</td><td>${dto.prdPrice}</td></tr>
				<tr><td>제조회사</td><td>${dto.prdCompany}</td></tr>
				<tr><td>재고</td><td>${dto.prdStock}</td></tr>
				<tr><td>제조일</td><td><fmt:formatDate value="${dto.prdDate}" pattern="YYYY-MM-DD"/></td></tr>
		</table><br><br>
    	<a href="<c:url value='/product/updateProductForm/${dto.prdNo}'/>">[상품정보 수정]</a>  
    	<a href="javascript:deleteCheck();">[상품정보 삭제]</a>   
	    <!--  index 페이지로 이동 링크 추가 -->
		<a href="<c:url value='/'/>">[홈으로 이동]</a> 
	
	</body>
</html>