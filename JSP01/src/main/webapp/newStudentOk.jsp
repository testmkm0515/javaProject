<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>폼에 입력된 값으로 빈 속성값 설정</title>
	</head>
	<body>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
		<!-- StudentBean 사용 모든 프로퍼티에 값 설정 StudentBean 클래스 필드에 값 저장, 필드명과 파라미터명을 매칭해서 자동 저장까지 진행-->
		<jsp:useBean id="student1" class="bean.StudentBean" scope="page">
			<jsp:setProperty property="*" name="student1"/>
		</jsp:useBean>
	
		<h3>빈 속성값 출력(Getter 사용)</h3>
		학번 : <%= student1.getStdNo() %><br>
		성명 : <%= student1.getStdName() %><br>
		전화 : <%= student1.getStdPhone() %><br>
		주소 : <%= student1.getStdAddress()%><br>
		학년 : <%= student1.getStdYear() %><br>	
		관심분야 : 	
		<%
			String[] stdInterests = student1.getStdInterest();
			for(int i=0; i<stdInterests.length; i++){
		%>
			<%=stdInterests[i] +  " "  %>
		<%
			}
		%>
		
	</body>
</html>





