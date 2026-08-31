<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>바인딩된 속성 EL 표현</title>
	</head>
	<body>
		바인딩된 속성은 getAttribute(속성명) 사용해서 바인딩된 값을 반환(java)<br>
		EL 표현어에서는 속성명만 나열해서 바인딩된 값을 반환<br>
		id 표현식: <%= request.getAttribute("id") %><br>
		id : ${id }<br>
		pwd : ${pwd }<br>
		name : ${name }<br>
		email : ${email }<br>
		
	</body>
</html>