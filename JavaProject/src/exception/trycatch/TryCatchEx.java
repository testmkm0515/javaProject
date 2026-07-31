package exception.trycatch;

public class TryCatchEx {

	public static void main(String[] args) {
		int[] arr = {1,2,3};
		//Class clazz = Class.forName("java.lang.String2"); //try ~ catch 구문에 없으면 강제 종료
		// 예외처리 블록 - 예외 발생 시 catch 실행 후 정상종료
		try { //예외 발생 가능성 있는 코드
			Class clazz = Class.forName("java.lang.String2");
		}catch(ClassNotFoundException e) {
			System.out.println("클래스가 존재하지 않습니다");
		}	
		//예외 처리 후 만나는 일반 문장은 정상 실행 됨
		System.out.println(arr[2]);

	}

}
