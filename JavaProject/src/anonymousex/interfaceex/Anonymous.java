package anonymousex.interfaceex;

public class Anonymous {
	// 인터페이스 타입의 필드 초기값으로 익명 구현 객체 사용
	IRemoteControl field = new IRemoteControl() {
		@Override
		public void turnOn() {
			System.out.println("TV를 켭니다");			
		}
		@Override
		public void turnOff() {
			System.out.println("TV를 끕니다");			
		}		
	};
	
	//메소드 내에서 인터페이스타입의 로컬변수에 값 대입시 익명 구현 객체 사용
	void method1() {
		//인터페이스타입의 로컬변수 선언 대입
		IRemoteControl localVar = new IRemoteControl() {
			@Override
			public void turnOn() {
				System.out.println("Audio를 켭니다");
				
			}
			@Override
			public void turnOff() {
				System.out.println("Audio를 끕니다");				
			}			
		};
		localVar.turnOn();
	}
	
	//인터페이스타입의 매개변수를 포함하는 메서드
	void method2(IRemoteControl rc) { //전달되는 파라미터는 인터페이스 구현 객체여야 함
		rc.turnOn();
	}
	
	
}









