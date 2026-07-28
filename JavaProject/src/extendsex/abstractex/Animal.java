package extendsex.abstractex;

public abstract class Animal {
	//추상 클래스는 일반 메서드 포함 가능
	public void show() {
		System.out.println("동물입니다");
	}
	
	//추상메서드 : 상속받으면 반드시 구현해야 함
	public abstract void sound();
}
