$(document).ready(function(){
	$('#prdNoCheckBtn').on('click',function(){
		
		event.preventDefault();
		
		let prdNo = $('#prdNo').val();
		
		if(prdNo == ""){
			alert("상품번호를 입력하세요");
			return false;
		}else{
			//서버로 상품번호 전달 중복확인 진행
			$.ajax({
				type:"get",
				url:"/mybatis/product/prdNoCheck1/"+prdNo, //uri data 전송
				//url:"/mybatis/product/prdNoCheck?prdNo="+prdNo, //쿼리스트링 방식의 전송
				dataType:"text",
				success:function(result){
					console.log(result);
					if(result=="available"){
						alert("사용가능한 번호입니다1");
					}else{
						alert("사용 불가능한 번호입니다1");
					}			
				},
				error:function(){
					alert("전송실패");
				}
			});//ajax끝		
		} //else끝
	}); //on 끝
});//ready 끝