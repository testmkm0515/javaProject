package classInfo;

public class ConstructorEx {

	public static void main(String[] args) {
		// 여러 형태의 생성자 사용 예시
		// 생성자가 없는 클래스 인스턴스 생성
		// 컴파일러가 포함시키는 기본 생성자 호출
		Constructor ct = new Constructor();
		
		// 매개변수가 없는 생성자만 있는 클래스
		// 명시적 생성자 호출
		Constructor1 ct1 = new Constructor1();
		
		// 매개변수가 있는 생성자만 있는 클래스
		// 명시적 생성자 호출-파라미터 반드시 필요
		Constructor2 ct2 = new Constructor2(10,20);	
		
		// 매개변수가 있는 생성자와 매개변수가 없는 생성자를 포함하는 클래스
		// 명시적 생성자 호출- 파라미터에 따라 서로 다른 생성자가 호출
		Constructor3 ct3 = new Constructor3(1,2);	
		Constructor3 ct3_1 = new Constructor3();
	}

}
