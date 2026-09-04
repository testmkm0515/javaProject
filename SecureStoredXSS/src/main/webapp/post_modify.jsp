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
<title>글 수정</title>
</head>
<body>
    <h1>글 수정</h1>
    <%
    try
    {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String user = "SQL_SELECT";
		String pwd = "1234";
        Connection connection = DriverManager.getConnection(url,user,pwd);
        
        request.setCharacterEncoding("UTF-8");
        
        String num = request.getParameter("num");
        
        String insertQuery = "SELECT * FROM pratice_board WHERE num=" + num;
        
        PreparedStatement psmt = connection.prepareStatement(insertQuery);
        
        ResultSet result = psmt.executeQuery();
        
        while(result.next())
        {%>
            <form action="post_modify_send.jsp" method="post">
            <input type="hidden" name="num" value="<%=result.getInt("num") %>">
            <table border="1">
                <tr>
                    <td>작성자</td>
                    <td><input type="text" name="writer" value="<%=result.getString("writer") %>"></td>
                </tr>
                <tr>
                    <td>제목</td>
                    <td><input type="text" name="title" value="<%=result.getString("title") %>"></td>
                </tr>
                <tr>
                    <td>내용</td>
                    <td><textarea rows="10" cols="20" name="content"><%=result.getString("content") %></textarea>
                </tr>
                <tr>
                    <td colspan="2">
                        <button type="submit">수정</button>
                        <button type="button" onclick="location.href='post_list.jsp'">목록으로</button>
                        <button type="reset">원상복구</button>
                    </td>
                </tr>
            </table>
            </form>
    <%
        }
    }
    catch (Exception ex)
    {
    	out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());
    }%>
</body>
</html>