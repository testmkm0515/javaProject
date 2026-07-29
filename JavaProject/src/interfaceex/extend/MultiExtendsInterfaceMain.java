package interfaceex.extend;

public class MultiExtendsInterfaceMain {

	public static void main(String[] args) {
		//인터페이스 상속에서의 다형성
		
		// 구현클래스 객체 생성
		ImplementationC c = new ImplementationC();
		
		// 인터페이스 참조변수에 대입
		// InterfaceA와 InterfacB는 동일 계층
		// InterfaceC는 InterfaceA와 InterfacB를 상속했으므로 하위계층
		
		// 상위 인터페이스는 자신의 추상 메서드 구현에만 접근 가능
		InterfaceA ia = c;
		ia.methodA();
		//ia.methodB();
		
		InterfaceB ib = c;
		ib.methodB();
		
		System.out.println("-----------------------------------------");
		//InterfaceA와 InterfacB를 상속받음으로써 InterfaceC참조변수는  상속받은 인터페이스 추상메소드
		//자신 추상메도구 구현체에 접근
		InterfaceC ic = c;
		ic.methodA();
		ic.methodB();
		ic.methodC();
		
		c.methodA();
		c.methodB();
		c.methodC();

	}

}
