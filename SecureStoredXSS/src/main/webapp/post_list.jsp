<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.Connection"%>
<%@page import= "java.sql.PreparedStatement"%>
<%@page import= "java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>게시글 목록</title>
</head>

<body>
	<form action="post_read.jsp" method="get">
		<h1>게시글 목록</h1>
		<% try { 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
			String user = "SQL_SELECT";
			String pwd = "1234";			
			Connection con = DriverManager.getConnection(url,user,pwd);	
			
			String query = "SELECT * FROM pratice_board order by num desc";
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet result = pstmt.executeQuery();		
		%>

			<table border="1">
				<tr>
					<td colspan="5">
						<h3>게시글 제목 클릭시 상세 열람 가능</h3>
					</td>
				</tr>
				<tr>
					<td colspan="5">
						<button type="button" value="신규 글 작성" onClick="location.href='post_new.jsp'">신규 글
							작성</button>
					</td>
				</tr>
				<tr>
					<td>번호</td>
					<td>작성자</td>
					<td>제목</td>
					<td>작성일</td>
					<td>관리</td>
				</tr>
				<% 
					while(result.next())
					{%>
						<tr>
							<td>
								<%=result.getInt("num") %>
							</td>
							<td>
								<%=result.getString("writer")%>
							</td>
							<td><a href="post_read.jsp?num=<%=result.getInt("num")%>">
									<%=result.getString("title") %>
								</a></td>
							<td>
								<%=result.getTimestamp("regdate") %>
							</td>
							<td>
								<button type="button" value="수정"
									onClick="location.href='post_modify.jsp?num=<%=result.getString("num") %>'">수정</button>
								<button type="button" value="삭제"
									onClick="location.href='post_delete_send.jsp?num=<%=result.getString("num") %>'">삭제</button>
							</td>
						</tr>
					<% }%>
			</table>
			<% } catch (Exception ex) { 
					out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());				
				}%>
	</form>
</body>
</html>