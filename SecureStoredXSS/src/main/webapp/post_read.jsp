<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.Connection" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>게시글 상세 열람</title>
</head>

<body>
	<h1>게시글 상세 열람</h1>
	<% try { 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
			String user = "SQL_SELECT";
			String pwd = "1234";			
			Connection con = DriverManager.getConnection(url,user,pwd);	
			
			request.setCharacterEncoding("utf-8");
			String num = request.getParameter("num");
			
			String query = "SELECT * FROM pratice_board where num=" + num;
			
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet result = pstmt.executeQuery();
	%>

	<table border="1">
		<% while(result.next()) {%>
			<tr>
				<td>번호</td>
				<td>
					<%=result.getInt("num") %>
				</td>
			</tr>
			<tr>
				<td>작성일</td>
				<td>
					<%=result.getTimestamp("regdate") %>
				</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>
					<%=result.getString("writer") %>
				</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>
					<%=result.getString("title") %>
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<%=result.getString("content") %>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button type=button onclick="location.href='post_list.jsp'">목록으로</button>
				</td>
			</tr>
			<% }%>
	</table>
	<% } catch (Exception ex) { out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());
    }%>

</body>
</html>