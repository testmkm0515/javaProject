package ramda.localvar;

//메서드 내부에서 함수형 인터페이스 참조변수 사용 예시
public class UsingThis {
	public int outterField = 10;
	public int field = 100;
	
	class Inner {
		int innerField = 20;
		int field = 200;
		
		void method(int arg) {
			//로컬변수는 생성 후 수정하지 않으면 람다식에서는 final로 인식 사용 가능
			int localVar = 40;
			int localVar2;
			localVar2=60;
			
			localVar2 += 20; //로컬변수 수정하면 함수형 인터페이스 구현 람다식에서는 사용 불가능
			
			//로컬변수 람다식구현시 final 특성 제약사항 
			MyFunctionalInterface fi = () -> {
				//로컬변수 사용
				System.out.println("arg : " + arg);
				System.out.println("localVar : " + localVar);
				//System.out.println("localVar : " + localVar2); //final이 아니므로 오류
				
				//바깥클래스 중첩클래스 필드의 이름이 다른 경우 바로 접근
				System.out.println("outterField : "+ outterField);
				System.out.println("innerField : "+ innerField);
				
				//바깥클래스 중첩클래스 필드의 이름이 같은경우 inner 클래스 접근
				System.out.println("outter : "+ field);
				System.out.println("inner : "+ field);
				
				//바깥클래스 중첩클래스 필드의 이름이 같은경우 this 활용 가능
				//outter 접근 바깥클래스명.this.필드명
				System.out.println("outter : "+ UsingThis.this.field);
				System.out.println("inner : "+ this.field);				
			};
			fi.method();
		}
	}
}




