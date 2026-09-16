$(document).ready(function(){
	$('#prdNoCheckBtn').on('click',function(){
		
		event.preventDefault();
		
		let prdNo = $('#prdNo').val();
		
		if(prdNo == ""){
			alert("상품번호를 입력하세요");
			return false;
		}else{
				//axios 기능 활용해서 비동기통신 진행 : js lib 및 스프링에 의존객체 필요
				axios.get("/mybatis/product/prdNoCheck5/" + prdNo)
				.then(function(response){
					console.log(response);
					if(response.data=="available"){
						 alert("사용 가능한 번호 입니다.5");
					}else{
						 alert("사용 불가능한 번호 입니다.5");
					}
				})
				.catch(err => console.log(err));
	
		} //else끝
	}); //on 끝
});//ready 끝