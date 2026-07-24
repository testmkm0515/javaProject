package classInfo;

public class SingletonEx {

	public static void main(String[] args) {
		// Singleton 클래스 인스턴스 생성
		//Singleton st = new Singleton();//생성자 private
		
		//static 메소드인 getInstance() 호출
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		
		if(obj1==obj2) {
			System.out.println("같은 객체를 참조합니다");
		}else {
			System.out.println("다른 객체를 참조합니다");
		}

	}

}
