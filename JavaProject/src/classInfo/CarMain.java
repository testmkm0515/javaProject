package classInfo;

public class CarMain {

	public static void main(String[] args) {
		// 프로그램의 실행과 종료
		// 클래스는 사용자 정의 타입 - 클래스 타입의 변수(참조 변수) 선언 가능
		// 설계도인 클래스를 이용해서 객체 인스턴스를 생성하면 생성할때마다 독립적인 인스턴스가 만들어 시작주소를 반환
		// 반환되는 시작주소를 클래스타입 변수에 저장해야 해당 인스턴스 사용가능
		// 만약, 어떤 변수도 인스턴스 주소를 저장하고 있지 않으면 가비지 인스턴스처리됨
		Car c1 = new Car(); // 생성자 함수 호출하고 메모리 할당(heap 영역)받아 클래스를 복사
		Car c2 = new Car();
		Car c3 = new Car();
		//c1=c2; //c1이 참조하던 인스턴스 주소가 삭제되어버리고 c1은 c2와 같은 인스턴스 참조
		
		//참조변수 활용해서 인스턴스 필드와 메소드 사용
		c1.carNo = "11가 1234";
		c2.carNo = "22나 5678";
		c3.carNo = "33가 1111";
		
		c1.carName = "아반떼";
		c3.carMaker = "현대";
		
		c1.showCarInfo();
		c3.showCarInfo();
		//객체 인스턴스는 독립적임
		
		System.out.println(c1.carName);
		System.out.println(c3.carMaker);
		
		int x = 0;
		int y = 0;
		y+=x;
		
		// 객체 인스턴스 삭제 - 참조주소를 삭제
		c1=null; //이전 참조 객체는 삭제됨
		
	}

}
