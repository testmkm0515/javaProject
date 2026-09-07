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
<title>게시글 상세 열람</title>
</head>
<body>
    <h1>게시글 상세 열람</h1>
    <%
	String S_ID = (String)session.getAttribute("S_ID");
	String S_NAME = (String)session.getAttribute("S_name"); 
    
    if (S_ID != null){
    try
    {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String db_address = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String db_username = "sql_select";
		String db_pwd = "1234";
		Connection connection = DriverManager.getConnection(db_address, db_username, db_pwd);

		request.setCharacterEncoding("UTF-8");
        
        String num = request.getParameter("num");
        
        String insertQuery = "SELECT * FROM pratice_board WHERE num=" + num;
        
        PreparedStatement psmt = connection.prepareStatement(insertQuery);
        
        ResultSet result = psmt.executeQuery(); 
        result.next();
        String name = result.getString("writer");
        %>
        
        <table border="1">

            	<tr>
            	    <td>번호</td>
            	    <td><%=result.getInt("num") %></td>
            	</tr>
            	<tr>
            	    <td>작성일</td>
            	    <td><%=result.getTimestamp("regdate") %></td>
            	</tr>
            	<tr>
            	    <td>작성자</td>
            	    <td><%=name %></td>
            	</tr>
            	<tr>
            	    <td>제목</td>
            	    <td><%=result.getString("title") %></td>
            	</tr>
            	<tr>
            	    <td>내용</td>
            	    <td><%=result.getString("content") %></td>
            	</tr>
            	<tr>
            	    <td>
            	        <button type=button onclick="location.href='post_list.jsp'">목록으로</button>
            	    </td>
					<td>
					<%			
					//세션에 저장된 이름과 db에 저장된 작성자가 같을경우에 수정/삭제 버튼을 활성화
					if(S_NAME.equals(name)){ %>
						<button type="button" value="수정" onClick="location.href='post_modify.jsp?num=<%=result.getString("num") %>'">수정</button>
						<button type="button" value="삭제" onClick="location.href='post_delete_send.jsp?num=<%=result.getString("num") %>'">삭제</button>
						<%} %>
					</td>            	    
            	</tr>
            	
        </table>
        <%
    }
    catch (Exception ex)
    {
        out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());
    }
    } else {
    	response.sendRedirect("main.html");   
    }%>

</body>
</html>