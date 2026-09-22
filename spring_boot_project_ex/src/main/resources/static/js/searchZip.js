/*
* 우편번호 찾기
*/

$(document).ready(function(){
  $('#searchZipBtn').on('click',function(){
		new daum.Postcode(
			{
				//우편번호 찾아 주소 선택하고 확인 신호를 보내면 실행할 콜백함수
				oncomplete:function(data){
					let address1 = "";
					let address2 = "";
					
					if(data.userSelectedType='R'){ //사용자 선택 주소가 도로명인경우
						address1 = data.roadAddress + "(" + data.bname + data.buildingName + ")" ;
					}else{//사용자 선택 주소가 지번 주소인 경우
						address1 = data.jibunAddress;
					}
					
					//주소 입력란에 생성한 주소를 표현(출력)
					document.getElementById('memZipcode').value = data.zonecode;
					document.getElementById('memAddress1').value = address1;
					
					address2 = document.getElementById('memAddress2');
					address2.value="";
					address2.focus();
				}
			}
		).open();
	
  });//on 끝
	
});//ready 끝







