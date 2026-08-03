package exception.throwsex;

public class Throws {

	public static void main(String[] args) {
		// 최종 실행 블럭인 main에서는 예외가 떠 넘겨진 메서드 사용하는 경우 try ~ catch로 예외처리 진행
		try {
			findClass();			
		}catch(ClassNotFoundException e) {
			System.out.println("클래스가 존재하지 않습니다");
		}

	}
	
	public static void findClass() throws ClassNotFoundException {
		//Class.forName()은 메소드 원형에서 예외를 떠 넘기고 있음
		//해당 메소드 호출 시 try ~ catch 블럭에서 호출하던가 호출 메서드가 throws를 진행하던가 해야함
		Class clazz = Class.forName("java.lang.String2");
	}

}
