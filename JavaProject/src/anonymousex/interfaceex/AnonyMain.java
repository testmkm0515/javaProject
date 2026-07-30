package anonymousex.interfaceex;

public class AnonyMain {

	public static void main(String[] args) {
		// 익명구현객체로 초기화된 인터페이스 타입의 참조변수 사용
		Anonymous anony = new Anonymous();
		
		// 익명구현객체로 초기화된 인터페이스 타입의 참조변수 사용
		anony.field.turnOn();

		// 익명 구현객체로 초기화된 인터페이스타입의 로컬변수를 포함하는 메소드 호출
		// 메소드에는 로켤변수를 통해 익명객체의 메소드 호출하는 코드 있음
		anony.method1();
		
		// 인터페이스 타입의 매개변수를 포함하는 메소드 호출
		// 호출시 파라미터로 익명 구현객체를 전달
		anony.method2(new IRemoteControl() {
			@Override
			public void turnOn() {
				System.out.println("SmartTV를 켭니다");
				
			}
			@Override
			public void turnOff() {
				System.out.println("SmartTV를 끕니다");				
			}
			
		});
	}

}
