package Operators;

public class AssignmentOp {

	public static void main(String[] args) {
		// 누적 대입 연산자(복합 대입 연산자)
		int result = 0;
		System.out.println(result += 10);
		System.out.println(result -= 5);
		System.out.println(result *= 3);
		System.out.println(result /= 5);
		System.out.println(result %= 3);
		
		// 삼항연산 : ?: 조건식 ? 참일때 : 거짓일때
		int score = 85;
		char grade = (score >= 90)? 'A': ((score >= 80 ? 'B' : 'C'));
		System.out.println(score + "점은 " + grade + "등급입니다");
	}

}
