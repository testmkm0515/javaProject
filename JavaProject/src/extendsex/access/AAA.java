package extendsex.access;

public class AAA {
	public int field1;
	int field2;
	private int field3;
	protected int field4;
	
	public AAA() {
		//클래스 내부 접근 제한 없음
		field1 = 1;
		field2 = 2;
		field3 = 3;
		
		method1();
		method2();
		method3();
	}
	
	public void method1() {}
	void method2() {}
	private void method3() {}
	
	
}
