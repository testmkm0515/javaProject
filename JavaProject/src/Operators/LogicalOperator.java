package Operators;

public class LogicalOperator {

	public static void main(String[] args) {
		// 논리 연산자
		int charCode = 'A';
		
		if ((charCode>=65) && (charCode<=90)) {
			System.out.println("대문자 입니다");
		}
		if ((charCode>=97) && (charCode<=122)) {
			System.out.println("소문자 입니다");
		}
		if ((charCode>=48) & (charCode<=57)) {
			System.out.println("0~9 숫자 입니다");
		}
		
		if (!(charCode<48) && !(charCode>57)) {
			System.out.println("0~9 숫자 입니다");
		}
		
		int value = 6;
		if((value%2==0) || (value%3==0)) {
			System.out.println("2또는 3의 배수입니다");
		}
		if((value%2==0) | (value%3==0)) {
			System.out.println("2또는 3의 배수입니다");
		}
		
		// 비트 논리 연산 확인 - 0또는 1일 반환
		System.out.println(0 & 1);
		System.out.println(1 & 1);
		System.out.println(1 & 0);
		System.out.println(1 | 0);
		System.out.println(1 ^ 0);
		System.out.println(1 ^ 1);
		
		//비트 논리 연산은 2진수로 변경후 비트 연산 진행 함
		System.out.println("45 & 25 = " + (45 & 25));
		System.out.println("45 | 25 = " + (45 | 25));
		System.out.println("45 ^ 25 = " + (45 ^ 25));
		System.out.println("~45 = " + (~45));
	}

}
