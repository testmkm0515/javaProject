<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
		//http://www.naver.com/#example -> 슬라이스는 시작인덱스부터 끝까지 추출 
		//#first.jsp -> 시작 idx 부터 마지막까지 추출해서 반환 : slice(1)
		//first.jsp가 반환
			const hash = window.location.hash.slice(1);
		    //javascript: function a(){setTimeout(function(){alert('악성스크립트실행')},1000)}; a();
			//const hash = javascript: function a(){setTimeout(function(){alert('악성스크립트실행')},1000)}; a();


			if(hash) {
				window.location.href = decodeURIComponent(hash); //hash 내용을 uri로 구성
				//현재 hash가 #first.jsp라면 /first.jsp로 변경 구성됨
			}
			
			window.addEventListener('hashchange', function(){
				window.location.href = decodeURIComponent(window.location.hash.slice(1));
			});
		
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









