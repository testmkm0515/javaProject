$(document).ready(function(){
	$('#prdNoCheckBtn').on('click',function(){
		
		event.preventDefault();
		
		let prdNo = $('#prdNo').val();
		
		if(prdNo == ""){
			alert("상품번호를 입력하세요");
			return false;
		}else{
			//서버로 상품번호 전달 중복확인 진행 - javascript 내장함수 fetch() 사용
			//fetch(요청url) 응답이 오면 then()실행 - 응답을 약속하고 fetch는 제외됨
			//1. 응답 객체를 사용가능한 형태로 변환(text로 파싱)
			//2. 두번째 then에서 파싱한 결과를 result로 받아 처리
			//fetch의 get 방식 : url만 전달
			fetch("/product/prdNoCheck1/" + prdNo)
				//.then(response => console.log(response.text())) 
				.then(response => response.text()) //응답객체를 text() 파싱
				.then(result => {
					console.log(result);
					if(result=="available"){
						alert("사용가능한 번호3");
					}else{
						alert("사용불가능한 번호3");
					}
				})
				.catch(err => console.log(err));
	
		} //else끝
	}); //on 끝
});//ready 끝