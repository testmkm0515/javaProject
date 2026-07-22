package conditioin;
import java.util.Scanner;

public class IfNested {

	public static void main(String[] args) {
		// 중첩 if 예제
		// 지불방식이 현금인지 카드인지 확인 각 방식에 따른 할인율을 적용 할인액을 계산해서 출력하는 프로그램
		Scanner sc=new Scanner(System.in);
		int num, pay ;
		
		// 지불방식 입력
		System.out.print("지불방식 입력 : 번호입력하세요 (1. 현금 2. 카드)");
		num = sc.nextInt();
		
		if(num==1 || num==2) {
			System.out.print("지불액 입력 : ");
			pay = sc.nextInt();
			
			if(num == 1) {
				//현금일때
				System.out.println("할인율 : 10%");
				System.out.println("할인액 : " + (int)(pay*0.1) + "원");
			}else {
				//카드일때
				System.out.println("할인율 : 5%");
				System.out.println("할인액 : " + (int)(pay*0.05) + "원");				
			}
			
			
		}else 
			System.out.print("잘못 입력하였습니다. 종료합니다");
		
		sc.close();
	}

}
