/**
 * index.js
 */

 $(function(){
	// 윈도우 스크롤(이벤트) 시 메인 메뉴 고정
	$(window).on('scroll',function(){
		//스크롤 문서의 스크롤바의 top(스크롤바 맨 위 위치)이 #headerBox 높이(logo 크기) 이상이면
		if($(document).scrollTop() >= $('#headerBox').height()){
			// 메인메뉴 고정시키고 그림자 표시 : 관련 클래스 mainMenuFixed mainMenuShadow 메인메뉴박스에 추가(addClass())
			//addClass에 추가할 클래스는 띄어쓰기를 이용해서 나열할 수 있다
			$('#mainMenuBox').addClass('mainMenuFixed mainMenuShadow');
		}else{//#headerBox가 보이면
			// 메인메뉴가 고정되어있고 그림자가 있으면 모두 제거: 관련 클래스 mainMenuFixed mainMenuShadow 메인메뉴박스에서 제거(removeClass())
			$('#mainMenuBox').removeClass('mainMenuFixed mainMenuShadow');
		}
	}); //윈도우 스크롤 이벤트 종료
	
	//moveToTop 이미지 클릭 시 top으로 이동(스크롤바를 맨위로 위치(scrollTop:0))
	$('#moveToTop').on('click',function(){
		$('html,body').animate({scrollTop:0},500);
	});//top버튼 종료
 }); //종료