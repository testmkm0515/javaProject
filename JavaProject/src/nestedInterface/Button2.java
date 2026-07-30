package nestedInterface;

public class Button2 {
	OnClickListener listener; 
	
	//구현 객체 따로 만들지 않고
	//클래스 내부에서 직접 익명 객체 대입해서 이벤트 처리하는 경우가 더 많다
	public void setListener(OnClickListener listener) {
		this.listener = listener;
	}

	//버튼 이벤트가 발생하면 호출하는 메서드
	void touch() {
		listener.onClick();
	}

	interface OnClickListener{
		void onClick();
	}
}
