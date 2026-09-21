/**
 * slideShow.js
 */

 $(function(){ //정적 생성 태그 요소 준비 후 js 실행
 	//이동한 이미지의 index 값 저장 변수(현재 위치 이미지의 idx)
 	var movedIndex=0; //첫번째 이미지의 idx로 초기화
	
	//슬라이드 패널을 움직여 주는 함수
	//index값을 전달 받아서 해당 인덱스로 이동
	//이전, 이후 버튼 전부 이 함수를 호출
	function moveSlide(index){ //왼쪽 이동거리 : index*1280 
		//전달받은 index 값을 movedIndex에 저장
		movedIndex = index ;
		
		//슬라이드 이동거리 : 왼쪽(왼쪽 여백을 줄이겠다)으로 이동 거리
		var moveLeft = -(1280*index)
		$('#slidePanel').animate({'left':moveLeft},'slow');		
	}
//******************************************************************************************* */	
	//prev 버튼 클릭하면 앞 이미지로 이동, 첫번째 이미지(idx 0)라면 이동할 곳이 없으므로 idx 변환 하지 않는다
	$('#prevButton').on('click',function(){
		if(movedIndex!=0){ //첫번째 이미지가 아니면
			movedIndex=movedIndex-1; //인덱스값을 1 감소
		}
		moveSlide(movedIndex);
	});
	//next 버튼 클릭하면 뒤 이미지로 이동, 마지막 이미지(idx 4)라면 이동할 곳이 없으므로 idx 변환 하지 않는다
	$('#nextButton').on('click',function(){
		if(movedIndex!=4){//현재 이미지가 마지막 이미지가 아니면
			movedIndex=movedIndex+1;//인덱스 값을 1 증가
		}
		moveSlide(movedIndex);
	});
//***************************************************************************************** */	
	//초기 슬라이더(이미지)위치 랜덤하게 지정 : Math.random() 0.0~0.9999999
	//이미지 idx 0~4
	var randomNumber = Math.floor(Math.random() * 5);
	moveSlide(randomNumber); //document.ready 이벤트 발생하면(정적태그요소 준비되면 실행)
	
	//3초마다 슬라이드 자동 이동 - setInterval(실행함수, 실행간격); => 함수를 실행간격 만큼의 시간을 두고 반복 실행
	setInterval(function(){  
		// 슬라이드 이동 코드 - idx 0번 이미지부터 idx 1씩 증가하면서 이미지 슬라이드 진행
		// idx 4의 이미지면 idx 0으로 복귀
		// 슬라이딩될 이미지의 idx 결정하는 코드
		// 현재 보고 있는 이미지 idx가 4가 아니면
		if(movedIndex != 4) //오른쪽 끝 마지막 이미지가 아니면
			movedIndex += 1 ; // 오른쪽 이미지로 이동
		else //오른쪽 끝 마지막 이미지면	
			movedIndex = 0 ; // 처음 이미지로 이동	
		
		moveSlide(movedIndex);//이동해야될 idx 값		
	},3000);
	
	
//**************************************************************************************** */
	//컨트롤 패널 내 각 컨트롤 버튼에 대해서 작업
	//컨트롤 버튼 이미지에 동일한 효과 - 배열형태로 참조해서 각각 버튼에 개별 효과가 들어가도록 each 함수 사용
	//선택한 컨트롤 버튼 idx와 보여야 될 이미지 idx가 동일하므로 선택된 컨트롤 버튼 index를 받아서 사용
	$('.controlButton').each(function(index){
		//컨트롤 버튼에 마우스 올렸을 때 이미지 변경(hover)
		$(this).hover(
			function(){ //마우스 올렸을때 이미지 변경(button2로 변경)
				$(this).attr('src','image/controlButton2.png');
			},
			function(){ //마우스 뗐을 때 이미지 변경(button1로 변경)
				$(this).attr('src','image/controlButton1.png');				
			}			
		); //hover 종료
		
		//컨트롤 버튼 클릭 했을 때 moveSlide()함수 호출
		$(this).on('click',function(){
			moveSlide(index);
		});
	});		
	
 });//종료
 
 
 
 
 
 
 
 
 
 