package anonymousex.interfaceex.ui;

public class Window {
	//멤버필드
	Button button1 = new Button();
	Button button2 = new Button();
	//멤버필드(인터페이스 타입) 초기화할때 익명구현객체 사용
	Button.OnClickListener listener = new Button.OnClickListener() {		
		@Override
		public void onClick() {
			System.out.println("전화를 겁니다");
		}
	};
	//생성자 함수
	Window(){
		//미리 생성한 필드를 파라미터로 전달
		button1.setListener(listener);
		//익명 구현 객체를 생성해서 파라미터로 객체 전달
		button2.setListener(new Button.OnClickListener() {			
			@Override
			public void onClick() {
				System.out.println("메시지를 보냅니다");
			}
		});
	}
	
}





