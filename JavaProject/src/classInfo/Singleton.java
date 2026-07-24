package classInfo;

public class Singleton {
	// Singleton 클래스의 객체 인스턴스를 1개만 생성되어 공유되도록 코딩
	private static Singleton singleton = new Singleton(); //프로그램 시작시 한번 생성
	
	private Singleton(){}; //private 은 클래스 내부에서는 사용가능 클래스 외부 사용 불가능
	
	static Singleton getInstance() { //인스턴스 없이 사용해서 인스턴스 참조주소를 반환받아야 하므로 static으로 생성
		// static 메소드 이므로 static 필드만 사용 가능
		return singleton; //객체 생성 후 리턴이 아니고 프로그램 시작시 생성된 인스턴스의 주소 반환
		// 리턴하는 변수가 static 이므로 프로그램 시작시 생성 후 저장 getInstance() 호출시마다 저장된 동일 주소 반환
	}
}
