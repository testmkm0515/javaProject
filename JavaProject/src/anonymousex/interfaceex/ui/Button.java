package anonymousex.interfaceex.ui;

public class Button {
	OnClickListener listener; //인터페이스타입	
	public void setListener(OnClickListener listener) {
		this.listener = listener;
	}
	void touch() {
		listener.onClick();
	}

	//중첩인터페이스
	interface OnClickListener{
		void onClick();
	}
}
