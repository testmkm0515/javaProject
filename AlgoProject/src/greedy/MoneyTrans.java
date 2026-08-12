package greedy;

import java.util.Scanner;

public class MoneyTrans {

	public static void main(String[] args) {
		// 금액 큰 단위 지불
		Scanner sc = new Scanner(System.in);
		
		int[] unit = {5000,1000,500,100,50,10};
		
		System.out.println("금액 입력 : ");
		int money = sc.nextInt();
		
		for(int i=0; i<unit.length; i++) {
			System.out.println(unit[i] + "원: " + money/unit[i]); //현재 단위로 변환
			money%=unit[i]; //변환하고 남은 금액
		}
		
		System.out.println("나머지 : " + money);


	}

}
