package extendsex;

class Parent1{
	
}

class Child1 extends Parent1{
	
}

public class InstanceOf {

	public static void main(String[] args) {
		// 객체 타입 확인 예시
		Parent1 p1 = new Parent1();
		System.out.println(p1 instanceof Parent1); //true
		System.out.println(p1 instanceof Child1);  //false
		
		Child1 c1 = new Child1();
		System.out.println(c1 instanceof Parent1); //true(자동형변환 가능한 관계이므로 true 반환)
		System.out.println(c1 instanceof Child1);  //true	
		
		Parent1 pc = new Child1(); //Child1 객체 인스턴스를 참조
		System.out.println(pc instanceof Parent1); //true(부모타입으로 형변환 되어서 참조가 저장됨)
		System.out.println(pc instanceof Child1);  //true(참조하는 객체인스턴스 Child1 타입)-강제 형변환
		
		Child1 c2 = (Child1)pc; //강제형변환 가능
		
		Child1 c3 = (Child1)p1; //문법적인 오류는 없음, 
		//(p1 instanceof Child1) 진행시 false가 반환되므로 실행오류 발생 - 강제형변환 전에 instanceof 연산 진행 권장
		
		
	}

}
