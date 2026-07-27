package extendsex.override2;

public class AirplaneEx {

	public static void main(String[] args) {
		// super 참조 사용 예시
		SuperAirplane sa = new SuperAirplane();
		sa.takeOff();
		sa.fly();
		sa.flyMode = SuperAirplane.SUPERSONIC;
		sa.fly();
		sa.flyMode = SuperAirplane.NORMAL;
		sa.fly(); //sub class 내부에서 super  class의 재정의 되기 전 fly()메소드를 호출하고 있음
		sa.land();

	}

}
