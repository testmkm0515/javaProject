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
        
        		
		<script>
		  //자바스크립트 정규식
		  let re1 = new RegExp('abc'); //문자열 패턴
		  let re2 = new RegExp(/ab+c/); //리터털형 패턴
		  let re3 = /abc/;
		  
		  const regex = /^[ㄱ-ㅎ|가-힣|a-z|A-Z|0-9| |]+$/;
		  
		  console.log(re1.test("abcde"));
		  console.log(/abc/.test("abxde"));
		  console.log(re2.test("abbcde"));
		  console.log(regex.test("<script"));
		  console.log(regex.test("script>"));
		  console.log(regex.test("scr<ipt"));
		  console.log(regex.test("script"));	
		  
		  function submitHandler(){ //정규식을 통해 특수문자 입력 불가능하도록 필터링
			  	const keyword = document.querySelector("input[name='keyword']");
		  		const regex = /^[ㄱ-ㅎ|가-힣|a-z|A-Z|0-9| |]+$/;
		  		if(!regex.test(keyword.value)){
		  			alert('특수문자는 입력할 수 없습니다');
		  			return false;
		  		}
		  		return true;
		  }
		</script>
	
	</head>
	<body>
		<div class="form">
			<form method="get" action="reflected2.jsp" onsubmit="return submitHandler()">
				<div class="form__input">
					<div>
						<span>검색어</span>
						<input type="text" name="keyword"/>
					</div>
				</div>			
				<input class="form__button" type="submit" value="검색"/>
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