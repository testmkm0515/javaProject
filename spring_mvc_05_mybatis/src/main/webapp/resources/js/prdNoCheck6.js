/*
 axios를 활용한 post 방식의 비동기 요청 처리 스크립트
 javascript 기능을 활용
*/

window.onload = function(){
	let prdNoCheckBtn = document.getElementById('prdNoCheckBtn');
	
	prdNoCheckBtn.addEventListener('click',()=>{
		event.preventDefault();
		let prdNo = document.getElementById('prdNo').value;
		
		if(prdNo ==  ""){
			alert("상품번호를 입력하세요");
		}else{
			//axios의 post 방식으로 요청시 data의 전달은 json 방식의 데이터를 구성해서 전달
			let data = {"prdNo" : prdNo}; //data가 key:value 타입으로 전달됨
			//post 방식의 data 전달은 header를 통해 전달 data는 header의 body를 통해 전달
			axios.post("/mybatis/product/prdNoCheck6", data)
				.then(function(response){
					if(response.data == "available"){
						alert("사용 가능한 번호 입니다. 6");
					}else{
						alert("사용 불가능한 번호 입니다. 6");					
					}
				})
				.catch((error)=>{
					console.log(error.response);
				})	
		}
	});
}


