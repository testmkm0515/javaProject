package extendsex.polymorphism;

public class Dog extends Animal{

	@Override
	public void show() {
		System.out.println("강아지 입니다");
	}
	
	@Override
	public void sound() {
		System.out.println("멍멍");
	}
	
	public void dogMethod() {
		System.out.println("dogMethod 입니다");
	}
}
