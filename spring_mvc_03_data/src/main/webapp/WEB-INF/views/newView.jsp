<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>경로 테스트</title>
</head>
<body>
	${no} <br>
	${name} <br>
	${year} <br>
	<p> url을 통한 데이터 전달<br>
		학생정보상세보기의 링크 예시
	</p>
	쿼리스트링 방식 : 파라미터로 전달 <br>
	학번 : <a href="/projectData/student/studentDetailView?no=${no }">${no }</a><br>
	<br>
	URI 방식 : 파라미터로 전달되지 않는다(PathVariable방식) <br>
	학번 : <a href="/projectData/student/studentDetailView/${no }">${no }</a><br>
	<br>
	URI 방식 : 여러 값을 전달 <br>
	학번 : <a href="/projectData/student/studentDetailView/${no}/${name}/${year}">${no }</a><br>	
	
	<br>
	URI 방식 : 여러 값을 전달 고정값 전달 가능 <br>
	학번 : <a href="/projectData/student/studentDetailView/1/홍길동/5">${no }</a><br>	
</body>
</html>


