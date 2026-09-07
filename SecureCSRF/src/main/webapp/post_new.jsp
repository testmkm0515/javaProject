<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신규 게시글 작성</title>
</head>
<body>
	<%
		//로그인 된 경우에만 신규 게시글 작성하도록 구성
		//게시글 입력 시 작성자 이름은 자동으로 출력되도록 구성
		String S_ID = (String)session.getAttribute("S_ID");
		String S_name = (String)session.getAttribute("S_name");
	  %>
	<% if(S_ID != null){ %>	  
    <h1>신규 게시글 작성</h1>
    <form action="post_new_send.jsp" method="post">
        <table>
            <tr>
                <td>작성자</td>
                <td><input type="text" name="writer" value="<%=S_name %>" readonly></td>
            </tr>
            <tr>
                <td>제목</td>
                <td><input type="text" name="title"></td>
            </tr>
            <tr>
                <td>내용</td>
                <td><textarea rows="10" cols="20" name="content"></textarea></td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="submit">저장</button>
                    <button type="button" onclick="location.href='post_list.jsp'">목록으로</button>
                    <button type="reset">초기화</button>
                </td>
            </tr>
        </table>
    </form>
    <% } else {
    	//로그인 안된 상태로 요청
    	response.sendRedirect("main.html");	
    }
    %>
    }
</body>
</html>