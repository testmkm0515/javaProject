/*
* id 중복조회
*/

$(document).ready(function(){
	$("#idCheck").click(function(){
		event.preventDefault();
		
		let memId = $('#memId').val();
		
		//1. id 입력했는지 여부 확인
		//입력하지 않았으면 메시지 출력 후 가입화면
		//입력했다면 ajax 호출해서 id 중복 여부 확인
		//사용가능하면 사용가능한 id 입니다 메시지 출력
		//아니면 불가능 메시지 출력
		//요청 url : /member/idCheck
		if(memId==""){
			alert("ID를 입력하세요");
		}else{
			$.ajax({
				type:"post",
				url:"/member/idCheck",
				data:{"id":memId},
				dataType:"text",
				success:function(result){
					if(result > 0){
						alert("사용할 수 없는 ID 입니다");
					}else {
						alert("사용 가능한 ID 입니다");
					}
				},
				error:function(){
					alert("실패");
				}
			});
		}
		
	});//클릭 끝
	
});//ready 끝