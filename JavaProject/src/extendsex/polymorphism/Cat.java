package extendsex.polymorphism;

public class Cat extends Animal{
	@Override
	public void show() {
		System.out.println("고양이 입니다");
	}
	
	@Override
	public void sound() {
		System.out.println("야옹");
	}	
}
