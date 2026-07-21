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
	}

}
