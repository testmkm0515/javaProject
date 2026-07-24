package classInfo;

public class StaticInfo {
	//인스턴스 멤버 필드와 멤버 메소드
	int a;
	void f1(int x) {a=x;} //인스턴스 메소드내에서 인스턴스 필드 사용 가능
	void f2(int x) {b=x;} //인스턴스 메소드내에서 static 필드 사용 가능
	
	//static  멤버 필드와 멤버 메소드
	//static 메소드는 static 멤버만 접근 할 수 있다
	static int b;
	static void s1(int x) {a = x;}//static 메소드에서 인스턴스 필드 사용불가
	static void s2(int x) {f1(3);}//static 메소드에서 인스턴스 메소드 호출 불가능
	static void s3(int x) {b=x;}//static 메소드에서 static 필드 사용
	static void s4(int x) {s3(3);}//static 메소드에서 static 메소드 호출
	
	////////////////////////////////
	/// static 멤버 선언 : static 키워드 사용(명시적 선언)
	static int staticVar; // 스태틱 필드
	static void staticMethod() { //스태틱 메소드	
		
	}
}

///////////////////////////////////////////
/// static 초기화 블록
/// 클래스가 메소드 영역으로 로딩될 때 자동으로 실행하는 블록
/// 클래스 내부에 여러개가 선언되면 선언된 순서대로 실행
class Test{
	static{
		//static 초기화 블록
	}
	{
		// 인스턴스 멤버 초기화 블록-거의 사용되지 않는다
	}
}

class Television{
	int a ; //인스턴스 멤버
	static String company = "Samsung";
	static String model = "LCD";
	static String info;
	//info=company + "-" + model;
	static {
		//단순 값을 저장하는 초기화가 아닌 복잡한 연산을 진행하는 경우 static 초기화 블록을 사용
		info=company + "-" + model;
	}
	{	//인스턴스 멤버 초기화 블록을 사용할 수 있음 단, 인스턴스는 생성자 함수 사용하는게 일반적
		a=10+50;
	}
}

// static 블럭 사용시 주의점 정리
class Test10{
	//인스턴스 필드와 메소드
	int a;
	void method() {/*...*/}	
	//스태틱 필드와 메소드
	static int staticA;
	static void staticMethod() {}
	
	static {
		a=1; //인스턴스 필드 사용 불가
		method(); //인스턴스 메소드 사용 불가
		staticA=10;
		staticMethod();
	}	
	//static은 this 사용 불가능
	static void staticMethod2() {
		this.a=10; //this는 인스턴스 참조기 때문에 static에서는 사용 불가능
		//static 메소드에서 인스턴스필드 또는 인스턴스메소드 사용 하려면 인스턴스 생성 후 사용
		Test10 t10 = new Test10();
		t10.a=10;
		t10.method();
	}
}














