window.onload = function(){
	
	let qty = 1; 
	
	let plusBtn = document.getElementById('plusBtn');
	let minusBtn = document.getElementById('minusBtn');
	
	plusBtn.addEventListener('click', ()=>{
		qtyChange(1);
	});
	
	minusBtn.addEventListener('click',()=>{
		qtyChange(-1);
	});
	
	function qtyChange(val){
		let stock = document.getElementById("stock").dataset.stock;
		console.log(stock);		
		qty = qty + val;	
		if(qty < 1) qty = 1 ;
		if(qty > stock){
			alert("재고가 부족합니다");	
		 	qty = stock;
			}
		//주문액 계산하고 qty와 계산금액을 출력하는 함수 호출
		calAmount();		
	}
	
	function calAmount(){
		//현재 수량과 주문 예정금액 참조 변수 선언 및 참조 연결
		let cartQty = document.getElementById('cartQty');
		let amount = document.getElementById('amount');
		//상품 가격 정보 추출
		let price = document.getElementById('price').dataset.price; //속성 data-price의 값을 반환

		
		let total = qty * price;
		
		//값 반영
		cartQty.value = qty;
		amount.innerHTML = total.toLocaleString(); //천단위 구분메소드 호출
	}
	
};





