$(document).ready(function(){ //문서 준비되는 시점에 발생하는 이벤트

	$('#frmLogin2').on('submit', function(){
		event.preventDefault(); //submit 이벤트 중지
	
		//서버로 요청할 때 전송할 data 준비
		let user_id = $('#user_id').val();
		let user_pw = $('#user_pw').val(); //"오타 있어서 수정함
		
		$.ajax({
			//비동기요청에 대한 요청 정보 나열 k:v
			type:"post", //method
			url:"login", //요청 url
			data:{"id":user_id, "pw":user_pw}, //서버로 전송할 파라미터(payload)
			dataType:'text', //서버로부터 반환받을 data의 type
			//요청에 대한 응답 데이터 처리 - sucess 처리 함수의 매개변수로 전달
			success:function(result){
				if(result=="success"){
					message="로그인 성공\n상품 조회 화면으로 이동합니다";
					location.href="/mybatis/product/listAllProduct";
					}
				else{
					message="로그인 실패";
					}
				alert(message);	
			},
		    error:function()
		    {
		    	alert("전송 실패");
		    },
		    complete:function(){
		    
		    }
		  });//ajax 끝
	
	
	});//on 끝

});//ready 끝