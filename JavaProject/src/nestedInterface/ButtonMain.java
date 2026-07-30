package nestedInterface;

public class ButtonMain {

	public static void main(String[] args) {
		// 중첩 인터페이스 객체 사용 방법 예시
		Button btn = new Button();
		
		//버튼 클릭 시 이벤트 처리 
		//CallListener 구현 객체 사용
		btn.setListener(new CallListener());
		btn.touch(); //메서드에서 listener.onClick()을 호출
		
		btn.setListener(new MessageListener());
		btn.touch();
		
		// 구현객체 사용하지 않고 익명 객체 직접 연결해서 클릭시 발생할 처리 내용을 결정
		Button2 btn2 = new Button2();
		btn2.setListener(
			new Button2.OnClickListener() {//익명객체 구현 부				
				@Override
				public void onClick() {//메서드 구현부
					System.out.println("사진을 찍습니다");
				}
			}); //setListener 메소드 호출 종료
		btn2.touch();
	}

}










