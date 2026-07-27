package extendsex.override;

public class ComputerEx {

	public static void main(String[] args) {
		int r = 10; 
		
		// 재정의 메소드 사용 예시
		
		// super class 메소드 호출
		Calculator cal = new Calculator();
		System.out.println("원의 넓이 : " + cal.areaCircle(r));
		
		System.out.println();
		// subclass 메소드 호출
		Computer com = new Computer();
		System.out.println("원의 넓이 : " + com.areaCircle(r)); //재정의된 메소드 호출
		
		// Calculator 클래스를 상속받은 클래스의 객체 메소드 사용
		Computer2 com2 = new Computer2();
		System.out.println("원의 넓이 : " + com2.areaCircle(r));//상속받은 부모 클래스 메소드 호출

	}

}
