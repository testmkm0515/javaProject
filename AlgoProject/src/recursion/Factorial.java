package recursion;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		// 사용자로부터 양의 정수를 입력받아 입력한 수까지 팩토리얼 값 구하기
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int n = sc.nextInt();
		
		System.out.print(n+"! =");
		System.out.println(" " + factorial(n));
	}
	
	static int factorial(int n) {
		if(n<=1) {
			return 1;
		}else {
			System.out.print(n + " * ");
			return n * factorial(n-1);
		}
	}

}
