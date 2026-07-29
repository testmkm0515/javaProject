package nestedclass.access;

public class A {
	//인스턴스 필드 선언 및 인스턴스 초기화
	//중첩된 클래스 타입의 인스턴스 필드 선언 및 생성시 제약 없음
	B field1 = new B();
	C field2 = new C();
	
	//인스턴스 메서드내에서 중첩클래의 초기화(객체 생성) 가능
	void method1() {
		B var1 = new B();
		C var2 = new C();
	} /**인스턴스 필드와 메서드에서는 중첩된 클래스(인스턴스멤버, 정적멤버)에 대한 참조 및 생성 가능**/
	
	//정적필드 선언 및 초기화 : 멤버클래스를 이용(정적멤버 클래스만 인스턴스 생성 초기화 가능)
	//static B field3 = new B();//No enclosing instance of type A is accessible 오류
	static C field4 = new C();
	
	//정적 메소드내부에서 멤버 클래스 참조변수 선언 및 초기화
	static void method2() {
		//B var1 = new B();//No enclosing instance of type A is accessible 오류
		C var2 = new C(); //클래스 이름으로 접근 가능
	}
	
	//인스턴스 멤버 클래스
	class B {}
	
	//정적 멤버 클래스
	static class C {}
}
