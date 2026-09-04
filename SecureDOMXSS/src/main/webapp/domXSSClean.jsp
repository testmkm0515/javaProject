<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
			const hash = window.location.hash.slice(1);

			if(cleanXSS(hash)) {
				window.location.href = decodeURIComponent(hash); 
			}
			
			window.addEventListener('hashchange', function(){
				const hash2 = window.location.hash.slice(1);
				if(cleanXSS(hash2)){
					window.location.href = decodeURIComponent(hash2);
				}
			});
			
			function cleanXSS(keyword){
				const regex = /^[ㄱ-ㅎ|가-힣|a-z|A-Z|0-9|.|]+$/;
				if(!regex.test(keyword)){
					alert('특수 문자는 입력할 수 없습니다.');
					return false;
				}
				return true;
			}
		
		</script>
	</head>
	<body>
		<a href="#first.jsp">First 바로가기</a>
		<a href="#second.jsp">Second 바로가기</a>
	</body>
</html>
<!--
	브라우저 해시를 멀티페이지를 요청하는 일반 서버 uri에도 사용함 
	브라우저 해시는 싱글페이지를 구성하는 경우에 링크를 위해서 사용을 하게 됨	
-->









