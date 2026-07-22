package loop;
import java.util.Scanner;

public class DoWhile2 {

	public static void main(String[] args) {
		// 특정 조건에 대하여 계속 반복하는 프로그램
		Scanner sc = new Scanner(System.in);
		int input=0;
		String answer="";
		
		System.out.println("과정 안내 프로그램");
		
		do {
			System.out.print("\n1~4번호 입력 : ");
			input = sc.nextInt();
			
			switch(input) {
				case 1: System.out.println("Java 프로그래밍");break;
				case 2: System.out.println("데이터베이스");break;
				case 3: System.out.println("빅데이터 분석");break;
				case 4: System.out.println("AI");break;
				default: System.out.println("잘못 입력 하였습니다");break;	
			}
			
			System.out.print("\n 계속 조회하시겠습니까? (y/n입력) : ");
			answer = sc.next(); //do~while의 종료조건
			
		}while(answer.contentEquals("y")); //사용자로부터 값을 입력받아 입력된 값이 y면 계속 반복
		
		System.out.println("종료 합니다");
		sc.close();	

	}

}
