<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<c:import url="/WEB-INF/views/layout/head.jsp"></c:import>
<script type="text/javascript" src="<c:url value='/js/login.js'/>"></script>
</head>
<body>
	<div id="wrap">
		<!-- top -->
		<c:import url="/WEB-INF/views/layout/top.jsp"></c:import>
		<section><!-- content -->
		        <h1 id="title">로그인</h1>
		        <form id="loginForm" name="loginForm" >
		          <table>
		            <tr><th> ID</th><td><input type="text" id="id" name="id" ></td></tr>
		            <tr><th>비밀번호</th>
		            	<td><input type="password" id="pwd" name="pwd" autocomplete="off"></td></tr>
		             <tr>
		                <td colspan="2" align="center" id="button">
		                    <br><input type="submit" value="로그인">
		                    <input type="reset" value="취소">
		                </td>
		            </tr>             
		            </table>
		        </form>			
		
		</section>
		<!-- bottom -->
		<c:import url="/WEB-INF/views/layout/bottom.jsp"></c:import>	
	</div>
</body>
</html>