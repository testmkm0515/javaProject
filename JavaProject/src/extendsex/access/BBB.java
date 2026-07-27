package extendsex.access;

public class BBB {
	public BBB() {
		AAA a = new AAA();
		
		a.field1 = 1;
		a.field2 = 1;
		a.field3 = 1; //private 접근 제한
		a.field4 = 1; //protected 접근 제한 동일 패키지 접근 가능
		
		a.method1();
		a.method2();
		a.method3(); //private 접근 제한
	}
}
