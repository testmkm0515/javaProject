package classInfo;

// 설계도 main 포함하지 않으므로 실행되지 않음
public class Car {
	//클래스 구성요소 필드(속성, 변수) + 메소드(기능, 함수)
	// 필드 구성 초기화 연산 가능
	String carNo;
	String carName;
	String carMaker;
	int carYear;
	int carCc;

	int x = 0;
	int y = 0;
	
	//일반 연산코드는 class에 표현 불가능
	// y+=x;
	// 메소드 : 객체를 통해 어디서든 접근 가능(public), 반환값 없음 : void
	// 클래스에서필요한 연산은 메소드 내부에서 진행
	public void showCarInfo() {
		System.out.println("차량번호 : " + carNo);
		y+=x;
	}
}
