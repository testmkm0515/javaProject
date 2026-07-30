package anonymousex;

public class AnonymousMain {

	public static void main(String[] args) {
		// 익명객체로 초기화된 클래스 필드 사용
		Anonymous anony = new Anonymous();
		
		// 익명객체로 초기화된 필드를 통해 재정의된 메소드 호출		
		anony.field.wake();
		//anony.field.work(); //익명객체 일반메소드는 외부에서 사용 불가능(이유는?field가 부모클래스 타입)
		
		// 로컬변수가 익명자식객체로 값이 대입된 메소드 호출
		anony.method1();
		
		//매개변수에 전달되는 파라미터의 값으로 Person을 상속받는 익명 자식 객체 인스턴스 
		anony.method2(new Person() {
			void study() {
				System.out.println("공부합니다");
			}
			@Override
			void wake() {
				System.out.println("8시에 일어납니다");
				study();
			}
		});

	}

}
