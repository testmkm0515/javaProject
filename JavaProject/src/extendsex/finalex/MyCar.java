package extendsex.finalex;

public class MyCar {//extends MyCar2{ //MyCar2는 final 클래스이므로 상속 불가능
	public int speed;
	
	public void speedUp() {
		speed += 1;
	}
	
	public final void stop() { //재정의 불가능 메소드
		System.out.println("차를 멈춤");
		speed = 0;
	}
}
