<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
	<form action="post_read.jsp" method="get">
		<h1>게시글 목록</h1>
		<%
			//로그인 성공 후 현재 페이지가 요청되었다면 S_ID 속성값이 있음, 로그인 실패면 null 임
			String S_ID = (String)session.getAttribute("S_ID"); //getAttribute Object 타입 반환
			System.out.println(S_ID);
			if(S_ID != null){ //URI통해 직접 접근 금지시키고 로그인 된 경우에만 목록을 출력함
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String db_address = "jdbc:oracle:thin:@localhost:1521/xepdb1";
				String db_username = "sql_select";
				String db_pwd = "1234";
				
				Connection connection = DriverManager.getConnection(db_address, db_username, db_pwd);
				
				String insertQuery = "SELECT * FROM pratice_board order by num desc";
				PreparedStatement psmt = connection.prepareStatement(insertQuery);
				ResultSet result = psmt.executeQuery();%>
				
				<table border="1">
					<tr>
						<td colspan="4">
							<h3>게시글 제목 클릭시 상세 열람 가능</h3>
						</td>
					</tr>
					<tr>
					    <td colspan="45">
					        <button type="button" value="신규 글 작성" onClick="location.href='post_new.jsp'">신규 글 작성</button>
					        <button type="button" value="로그아웃" onClick="location.href='logout.jsp'">로그아웃</button>
					    </td>
					</tr>
					<tr>
						<td>번호</td>
						<td>작성자</td>
						<td>제목</td>
						<td>작성일</td>
					</tr>
					<%
					while (result.next())
					{%>
						<tr>
							<td><%=result.getInt("num") %></td>
							<td><%=result.getString("writer") %></td>
							<td><a href="post_read.jsp?num=<%=result.getInt("num") %>"><%=result.getString("title") %></a></td>
							<td><%=result.getTimestamp("regdate") %></td>
						</tr>
					<%
					}%>
				</table>
			<%
			}
			catch (Exception ex)
			{
				out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());
			}
			
			} else {
				//S_ID 없으면 main.html로 재요청
				response.sendRedirect("main.html");
			}%>
	</form>
</body>
</html>