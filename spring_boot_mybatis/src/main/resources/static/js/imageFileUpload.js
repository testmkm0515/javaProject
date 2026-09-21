/*

*/

$(document).ready(function(){arguments
	$('#imageFileForm').on('submit', function(){
		event.preventDefault();
		
		//폼 데이터 읽어오기
		let formData = new FormData($('#imageFileForm')[0]);
		
		let fileName = $('#uploadFile').val().split('\\').pop(); //파일명만 추출
		// E: \\ hy9\ \ springBootWorkspace \\ 1001.jpg
		
		$.ajax({
			type:"post",
			url:"imageFileUpload",
			enctype:"multipart/form-data",
			processData:false, //multipart/form-data이므로 임의변경(문자열로) 하디 않도록
			contentType:false, //contentType은 자체처리에 의존
			data:formData,
			success:function(result){
				alert(result);
				if(result=='success'){
					$('#imageBox').html('<img src="/images/'+fileName+'" width="400" height="300">');					// /images : url 매핑이름
					// 개발자가 직접 url 매핑을 진행해 줘야 함 -> WebConfig.java에서 진행
					
				}				
			},
			error:function(){alert("실패")}			
		});//ajax 끝		
	}); //on끝	
});//ready끝












