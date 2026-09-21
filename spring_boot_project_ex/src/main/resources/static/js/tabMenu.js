/**
 * tabMenu.js
 */

 $(function(){
	var $tabContent = $('#tabContent div'); //tabContent 내 이미지 모두
	//첫번째 메뉴 항목 선택되어 있게
	//동적으로 css 적용할 때 동적 style을 작성하는게 아니고 css 파일에 정적으로 스타일을 만들어 놓고
	//동적으로 클래스 속성을 태그에 추가하는 방법
	$('#tab li:first-child').addClass('selectedItem');
	//탭 메뉴 항목 클릭하면 
	$('#tab li').on('click',function(){
		//클릭한탭 메뉴 항목의 idx 알아오기
		var idx = $(this).index();
		//항목 idx에 맞는 이미지로 변경

		//모든 탭 메뉴 선택 항목에 반영된 css가 있다면 제거
		//동적으로 태그 설정 클래스를 제거
		$('#tab li').removeClass('selectedItem');		
		//클릭한 항목에만 CSS가 설정된 클래스 추가
		$(this).addClass('selectedItem');
		
		//content의 모든 div 숨기고
		$tabContent.css('display','none');
		//항목 idx의 이미지 컨텐츠만 보이게
		$tabContent.eq(idx).css('display','block');
	});	
	
 }); //종료