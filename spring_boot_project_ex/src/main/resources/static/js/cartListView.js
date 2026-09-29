/* 
 	전체선택과 삭제요청 처리할 자바스크립트 
*/

$(document).ready(function(){
	//주문 수량 변경 시 구매예정금액 변경
	let amount = $('.amount');//구매 예정 금액-배열반환
	let price = $('.price');//상품 가격
	let sum = 0;
	
	$.each($('.cartQty'),function(i){
		$(this).on('keyup',function(index){
			let qty = $(this).val();
			//구매예정금액과 총구매예정금액 변경하는 스크립트 코드 작성
			amount[i].dataset.amount = (price[i].dataset.price * qty);
			amount[i].innerHTML = (price[i].dataset.price * qty).toLocaleString();	
			//총 구매예정금액 계산하는 함수 호출
			sumAmount();
			document.getElementById('total').textContent = sum.toLocaleString();		
		});
	});
	
	function sumAmount(){
		//각 상품의 구매예정금액을 추출해서 모두 더한 결과를 sum 변수에 저장
		//호출시마다 새로계산하므로 sum은 0으로 리셋후에 연산을 진행
		sum = 0 ;
		document.querySelectorAll('.amount').forEach(function(amount,index){
			sum += (Number)(amount.dataset.amount)
		});
	}
	

	
	
	
	//[전체선택] 체크박스 체크한경우
	$("#allCheck").on('click',function(){
		let chk = $("#allCheck").prop("checked");
		
		if(chk){ //전체 선택이 체크된 경우
			$(".chkDelete").prop("checked",true);
			
		}else{//전체 선택 체크가 풀린 경우
			$(".chkDelete").prop("checked",false);
		}	
	});//on 끝	
	
	//개별 체크박스 해제할 경우 [전체선택] 체크박스 해제
	//개별 체크박스 모두 체크되었을대 [전체 선택] 체크박스 체크
	$('.chkDelete').on('click', function(){
		//어떤 개별 체크박스에서던 click이벤트가 발생하면 아래 절차를 수행
		//클래스 선택자 .은 객체참조를 요소로 갖고있는 배열 반환
		let total = $('.chkDelete').length;//개별체크박스의 전체 개수
		let checked = $('.chkDelete:checked').length; //. 클래스선택자를 우선 진행하고 그 결에에 : 속성선택자를 연결해서 진행, 배열을 반환
		
		if(total != checked){
			$("#allCheck").prop("checked",false);
		}else{
			$("#allCheck").prop("checked",true);
		}		
	});//on 끝
	
	//삭제 버튼 클릭 이벤트 처리 함수 연결(목록 체크된 내용에 따라 삭제 요청(비동기방식))
	$('#deleteCartBtn').on('click',function(){
	
		let chk = $('.chkDelete').is(':checked'); //checked속성값이 true인 요소가 하나라도 있으면 true를반환
		if(chk){ //하나이상 선택된 경우
			let answer = confirm("선택된 상품을 삭제하시겠습니까?");
			if(answer){ //비동기방식으로 삭제 요청(ajax)
				let checkArr = new Array();
				$(".chkDelete:checked").each(function(){
					console.log($(this).val());
					checkArr.push($(this).val());	//서버로 전송되는 파라미터는 cartNo가 전송				 
				}); //each끝
				
				//서버에 비동기 요청
				$.ajax({
					url:"/product/deleteCart",
					type:"post",
					data:{"delPrd":checkArr},
					success:function(result){
						if(result){
							location.href="/product/cartList";//delete된 결과 반영하는 페이지를 요청
						}
					},
					error:function(){
						alert("오류발생");
					}
				});
			}			
		}else{//하나도 선택되지 않은 경우
			alert("선택된 상품이 없습니다");
		}	
	});//on끝
	
});








