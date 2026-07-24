package classInfo;

public class CalculatorStatic {
	static double pi = 3.14159; //일반적으로 static 필드는 선언과 동시에 초기값 설정
	
	static int plus(int x, int y) {
		return x+y;
	}
	
	static int minus(int x, int y) {
		return x-y;
	}	
	
	public static void main(String[] args) {
		double result1 = 10*10*CalculatorStatic.pi; //static 멤버는 클래스명으로 바로 접근
		int result2 = CalculatorStatic.plus(10, 5);
		int result3 = CalculatorStatic.minus(10, 5);
		
		System.out.println("result1 : "+result1);
		System.out.println("result2 : "+result2);
		System.out.println("result3 : "+result3);
	}
}
