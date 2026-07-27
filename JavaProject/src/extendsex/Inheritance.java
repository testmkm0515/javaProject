package extendsex;
import extendsex2.Child2;

public class Inheritance {

	public static void main(String[] args) {
		// 상속받은 클래스(자식클래스)활용 부모 메소드 또는 필드 사용 예시
		// 동일 패키지내에 있는 서브클래스 Child 인스턴스 생성
		Child ob = new Child();
		ob.p2 =10;
		ob.p3 =50;
		ob.setChild(); //Child 클래스 메소드
		ob.setParent();//자식 클래스 객체 통해 부모 클래스 메소드 사용
		ob.showChild();
		ob.showParent();//부모 클래스 메소드 사용
		
		// 다른 패키지에 있는 서브 클래스 Child2 인스턴스 생성
		Child2 ob2 = new Child2();
		ob2.p3 = 10; //부모필드 사용(public)
		ob2.showChild();
		ob2.setChild();
		ob2.setParent();//부모 메서드 사용(public)
		//ob2.showParent(); //The method showParent() from the type Parent is not visible
	}

}
