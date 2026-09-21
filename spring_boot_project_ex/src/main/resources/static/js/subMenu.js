/**
 * subMenu.js
 * 전체보기 메뉴 항목 클릭했을 때 Sub Menu 보임
 * JQuery 코드 작성
 */

 $(function(){ // $(document).ready(function()); 의 축약 코드
 
    //1. [전체보기] 클릭했을 때 sub 메뉴 항목 보이게하고 메뉴 text를 메뉴닫기
    //2. [메뉴닫기] 클릭했을 때 sub 메뉴 항목 안보이게 하고 메뉴 text를 전체보기
    
 	$('#showAllMenu').on('click',function(){
		//현재 메뉴의 텍스트 확인
		if($(this).text()== '전체보기 ▼'){ //sub 메뉴 닫힌 상태
			$('#subMenuBox').css('visibility','visible'); //hidden->visible : 메뉴가 보이게
			$(this).text('메뉴닫기 ▲').css('color','blue'); //sub 메뉴 보이는 상태->메인메뉴 전체보기=>메뉴닫기
		}else{ //sub 메뉴 열린 상태
			$('#subMenuBox').css('visibility','hidden'); //메뉴 안보이게
			$(this).text('전체보기 ▼').css('color','black'); //sub 메뉴 안보이는 상태->메인메뉴 메뉴닫기 => 전체보기
		}
		
	}); //click on 끝	
 }); //$(function() 끝