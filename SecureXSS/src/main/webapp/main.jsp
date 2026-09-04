<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>keyword 확인</title>
        <style>
            .form {
                border: #323232 solid 1px;
                margin: auto;
                padding: 10px;
                width: 70vw;
                height: 100%;
            }

            .form__input {
                display: flex;
                flex-direction: column;
                gap: 1rem;
            }

            .form__input>div {
                display: flex;
                justify-content: space-between;
            }

            .form__button {
                margin-top: 10px;
                width: 100%;
            }

            .container {
                position: relative;
                overflow-x: auto;
                border: #323232 solid 1px;
                margin: 10px auto;
                padding: 10px;
                width: 70vw;
                height: 300px;
            }

            .container__header {
                position: absolute;
                top: 1rem;
                right: 1rem;
            }
        </style>		
	</head>
	<body>
		<div class="form">
			<form method="get" action="reflected.jsp">
				<div class="form_input">
					<div>
						<span>검색어</span>
						<input type="text" name="keyword"/>
					</div>
				</div>			
				<input type="submit" value="검색"/>
			</form>	
		</div>
		<div class="container">
			<%
				//keyword값이 서버로부터 전송된 경우에는 여기서 출력
				request.setCharacterEncoding("UTF-8");
				String keyword = request.getParameter("keyword");
				if (keyword==null){
					keyword="";
				}				
			%>
			
			<div class="container__header">
				검색어 : <%=keyword %> <br>
				검색결과 : 
			</div>
		</div>
	</body>
</html>