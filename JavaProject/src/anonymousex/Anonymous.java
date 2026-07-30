package anonymousex;

//익명 자식객체 생성 예시
public class Anonymous {
	
	//멤버필드 초기화 : Person클래스를 상속받는 익명자식객체 인스턴스로 초기화
	Person field = new Person() {
		//Person을 상속받은 익명객체의 구현부		
		//익명객체 일반 멤버메서드 외부사용 불가능 익명클래스 내부에서만 사용 가능
		void work() {
			System.out.println("출근합니다");
		}
		//상속받은 메서드재정의
		@Override
		void wake() {
			System.out.println("6시에 일어납니다");
			work();
		}		
	};
	//로컬변수를 초기화할 때 익명자식객체 사용
	//멤버메소드
	void method1() {
		//로컬변수의 값으로 익명자식객체 인스턴스 대입
		Person localVar = new Person() {
			void work() {
				System.out.println("산책합니다");
			}
			@Override
			void wake() {
				System.out.println("7시에 일어납니다");
				this.work(); //this : 이 시점의 익명객체클래스를 의미
			}
		};
		
		//메소드내부에서 로컬변수 사용해서 재정의된 메소드 호출
		localVar.wake();
	}
	
	//매개변수(Person 타입이 참조할 수 있는 인스턴스)를 이용해서 익명 자식 객체 사용
	void method2(Person person) {
		person.wake();
	}
	
}






