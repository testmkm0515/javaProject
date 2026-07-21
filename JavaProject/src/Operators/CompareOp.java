package Operators;

public class CompareOp {

	public static void main(String[] args) {
		// 비교 연산자 - true/false
		// 대소 : < <= > >=
		// 동등 : == != -> 가중치 데이터에 대한 동등 비교
		
		int num1 = 10; int num2 = 10;
		
		boolean result1 = num1 == num2; //두 변수의 값이 같으면 true
		System.out.println(num1 != num2); //두 변수의 값이 같지 않으면 true
		
		char char1 = 'A'; // 아스키 65
		char char2 = 'B'; // 아스키 66
		System.out.println(char1>char2);
		
		//문자열 비교 
		String pass = "1234";
		String userPass = "1234";
		
		System.out.println(pass == userPass); // 결과가 올바르게 나오더라도 문자열의 비교는 비교 연산자를 쓰지 않는다
		
		// 문자열의 비교는 문자열 메소드 equals() 메소드 사용
		System.out.println(pass.equals(userPass));

	}

}
