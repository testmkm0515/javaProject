package Operators;

import java.util.Scanner;

public class ArithmeticOpEtc {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 산술연산
		int num1, num2 ;
		
		System.out.print("정수 1 입력 : ");
		num1 = sc.nextInt(); //키보드 통해 입력된 값을 int형 변환 후 반환, 문자입력시 오류 발생됨
		System.out.print("정수 2 입력 : ");
		num2 = sc.nextInt();
		
		System.out.println(); //콘솔에서 커서 아래로 내림
		System.out.println(num1 + num2);
		System.out.println(num1 - num2);
		System.out.println(num1 * num2);
		System.out.println(num1 / num2); //정수 / 정수 -> 정수
		System.out.println(num1 % num2); //나눈 나머지 연산 (정수 반환)
		
		// 결과값 산출시 Overflow 주의
		// Overflow 연산후 결과값이 너무 커서 저장 범위 초과하는 경우 Overflow 발생
		// 에러없이 쓰레기 값(잘못된 값) 저장 됨
		int x = 1000000;
		int y = 1000000;
		
		int z = x * y; // 조단위 수치가 저장되어야 함 
		
		System.out.println(z); //-727379968 출력됨 (잘못된값) : overflow 발생
		//연산결과가 커질것을 예상할 수 있다면 데이터 타입의 크기를 확장해야 함
		
		//NaN 연산과 Infinity 연산은 주의할 것
		//System.out.println(10/0); //실행오류 발생 - / by zero
		//System.out.println(10/0.0); //Infinity
		
		//System.out.println(10%0); // / by zero
		System.out.println(10%0.0);	// NaN 	
		
		// 문자열 연결 연산자 (+) : 피연산자 중 문자열이 있으면 문자열 결합
		System.out.println(10+20+"30"); // 산술연산 후 결합연산
		System.out.println("30"+10+20); // 결합연산 후 결합연산
		
		
	}

}
