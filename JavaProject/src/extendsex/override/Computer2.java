package extendsex.override;

public class Computer2 extends Calculator{
	//개발자의 실수로 오타가 남 : 메서드 이름이 달라짐
	//부모 클래스 areaCircle()와 자식클래스의 areaCircel() 메서드가 생성됨
	//@Override가 필수는 아니지만 개발자의 실수를 줄일 수 있다
	@Override
	double areaCircel(double r) { //왼쪽 선언에 해당하는 메소드 선언부가 부모클래스에 없다는 오류, 메서드 이름이 다름
		System.out.println("Computer2 객체의 areaCircle() 실행");
		return Math.PI * r * r;
	}
}
