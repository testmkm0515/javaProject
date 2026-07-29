package nestedclass;

public class NestedMain {

	public static void main(String[] args) {
		// 바깥 클래스 A의 객체 생성
		A a = new A();
		
		// 인스턴스 멤버 클래스 객체 생성 : 바깥 클래스 인스턴스 참조가 필요
		A.B b = a.new B();
		b.field1 = 3;
		b.method1();
		
		// 정적 멤버 클래스 객체 생성 - scatic 클래스지만 인스턴스 멤버 포함하고 있음		
		A.C c = new A.C();
		c.field1 = 3;
		c.method1();
		//정적 멤버 클래스에 포함된 정적 멤버 접근은 객체를 통해도 되지만 클래스이름으로 접근하는게 일반적
		A.C.field2 = 3;
		A.C.method2();
		
		// 로컬 클래스 : 메소드 내부에 선언된 클래스 메소드 호출시 사용 가능
		// 메소드 내부에서 객체 생성 코드가 준비되어 있어야 함
		a.method();

	}

}
