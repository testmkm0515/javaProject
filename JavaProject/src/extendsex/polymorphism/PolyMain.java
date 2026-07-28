package extendsex.polymorphism;

public class PolyMain {

	public static void main(String[] args) {
		// 다형성 예시
		Animal a = new Animal(); //Animal 인스턴스 대입
		a.show();
		
		Cat c = new Cat(); //Cat인스턴스 대입
		c.show();
		Dog d = new Dog(); //Dog 인스턴스 대입
		d.show();
		
		//다형성
		a = new Cat(); //Animal 타입 참조변수에 Cat타입의 인스턴스가 대입 Cat->Animal 자동형변환
		System.out.println("Cat타입 인스턴스가 Animal 참조변수로 대입되면서 형변환 발생");
		a.show();
		a.sound();
		
		//다형성이 진행된 경우 부모클래스 참조변수는 부모클래스의 멤버만 접근 할 수 있지만
		//메소드가 재정의된 경우 자식클래스 메소드를 사용하게 됨
		a = new Cat2(); //Cat2는 show가 재정의 되지 않았으므로 Animal메소드가 호출됨
		a.show(); 
		//a.show1(); //Cat2인스턴스가 대입이 되었지만 Cat2인스턴스의 일반멤버는 사용불가능 재정의 되지 않았다면 부모클래스 멤버만 사용 가능
		
		//상속된 또다른 객체 인스턴스도 대입 가능
		a = d ; //Animal = Dog
		a.show();
		a.sound();
		
		/////////////////// 객체 치환 //////////////////////////////////
		Animal ap = new Animal();
		ap = new Cat(); 
		//객체 치환이 일어나는 경우 원래 참조하던 객체 참조를 잃어버림
		//어떤 변수도 참조하지 않는 인스턴스는 가비지가 되어서 jvm에 의해 자동으로 수거
		
		////// 다형성의 자동 형변환 및 강제 형변환 ////////////////
		Animal ap1 = null;
		
		// 자동형변환 예시
		ap = new Cat(); //sub클래스 인스턴스 타입이 대입되면서 superclass 타입으로 자동 형변환
		ap.show();
		ap.sound(); 
		
		ap1 = new Dog(); //sub클래스 인스턴스 타입이 대입되면서 superclass 타입으로 자동 형변환
		ap1.show(); //재정의된 메소드
		ap1.sound();
		//ap1.dogMethod(); //sub클래스 메소드 사용 불가능(재정의 되지 않았음)
		ap1.animalMethod();//super 클래스 메소드 사용 가능
		
		// 강제 형변환 예시
		//Dog 객체를 참조하는 변수는 ap1만 있다고 가정-Dog객체의 일반메서드는 사용 불가능
		//단, ap1의 참조주소는 Dog 객체 주소이므로 강제 형변환 가능
		Dog d1 = (Dog)ap1;
		//d1과ap1은 같은 인스턴스 참조(단, 성격은 다름)
		d1.dogMethod(); //자식객체의 메소드 사용 가능
		
		// 강제 형변환은 변환 하려는 부모객체가 자식객체의 인스턴스를 참조하는 경우에만 가능
		
		/////////////////// 객체의 타입을 확인 연산자 : instanceof
		Animal aa = new Animal();
		//Dog dd = (Dog)aa; //문법적 오류는 없음 단, aa 참조변수가 Dog 타입을 참조하고 있지 않았음
		// 실행 오류 발생 : cannot be cast
		
		if(aa instanceof Dog) {//강제형변환 진행할 클래스 타입인지 확인 후에 형변환 진행
			Dog dd = (Dog)aa;
			System.out.println("Dog 타입으로 변환 성공");
		}else {
			System.out.println("Dog 타입으로 변환 불가");
		}
		
		aa = new Dog();
		if(aa instanceof Dog) {//강제형변환 진행할 클래스 타입인지 확인 후에 형변환 진행
			Dog dd = (Dog)aa;
			System.out.println("Dog 타입으로 변환 성공");
		}else {
			System.out.println("Dog 타입으로 변환 불가");
		}		
	}

}






