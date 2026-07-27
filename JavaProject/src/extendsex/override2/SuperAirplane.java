package extendsex.override2;

public class SuperAirplane extends Airplane {
	static final int NORMAL = 1;
	static final int SUPERSONIC = 2;
	int flyMode = NORMAL;
	
	@Override
	public void fly() {
		if(flyMode==SUPERSONIC) {
			System.out.println("초음속 비행합니다");
		}else {
			//일반 비행은 부모 클래스 메소드
			super.fly(); //super 참조를 통한 재정의 전 부모클래스 메소드 사용
		}
	}
}
