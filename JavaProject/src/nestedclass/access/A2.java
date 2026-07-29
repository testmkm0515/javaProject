package nestedclass.access;

//멤버 클래스 종류에 따라 바깥 클래스 멤버를 접근할 때 제약
public class A2 {

	//바깥 클래스 A2의 인스턴스 멤버 필드, 메소드
	int field1;
	void method1() {};
	
	//바깥 클래스 A2의 정적 멤버 필드, 메소드
	static int field2;
	static void method2() {};	
	
	class B2{ //인스턴스멤버클래스 메서드에서 바깥 클래스 필드와 메서드 종류 상관없이 접근해서 사용 가능
		void method() {
			field1 = 3;
			method1();
			field2 = 2;
			method2();
		}
	}
	
	static class C2{//정적멤버클래스 바깥 클래스 필드와 메서드 종류 상관없이 접근해서 사용가능한지
		// 정적 멤버 클래스 메서드에서 바깥클래스의 인스턴스 필드와 메서드는 사용이 불가능 합니다
		void method() {
			//field1 = 3; //Cannot make a static reference to the non-static field field1
			//method1(); //Cannot make a static reference to the non-static method method1() from the type A2
			field2 = 2;
			method2();			
		}
	}
}











