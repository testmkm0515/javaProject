package datastructure.collection.hashset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LottoStore {
	Scanner scan = new Scanner(System.in);
	
	//메뉴를 출력하고 실행할 메뉴 번호 입력 반환하는 메서드
	public int displayMenu() {
		System.out.println("=====================");
		System.out.println("====Lotto 프로그램 ==");
		System.out.println("=====================");
		System.out.println("1. Lotto 구입 2. 프로그램 종료");
		System.out.println("=====================");
		System.out.print("메뉴 선택 : ");
		int num = scan.nextInt();
		return num;
	}
	
	public void lottoStoreStart() {
		while(true) {
			int choice = displayMenu();
			switch(choice) {
				case 1 : //Lotto 구입
					buyLotto();
					break;
				case 2 : //프로그램 종료
					System.out.println();
					System.out.println("종료");
					return;
				default :
					System.out.println("메뉴를 다시 선택하세요. 번호가 없습니다");
			}
		}
	}
	
	//로또 구매 메서드
	public void buyLotto() {
		System.out.println();
		System.out.println("Lotto 구입 시작 ");
		System.out.println();
		System.out.println("Lotto 한장 1000원 ");
		System.out.print("금액 입력 : ");
		int money = scan.nextInt();
		
		if(money < 1000) {
			System.out.println("금액이 모자랍니다. 로또 구입 실패! ");
			return;
		}else if(money>=1001000) {
			System.out.println("입력 금액이 너무 많음. 로또 구입 실패! ");
			return;			
		}
		
		getLotto(money); //로또 생성 메서드
		
		System.out.println("받은 금액은 " + money +"원이고, 거스름돈은 " + (money%1000) + "원 입니다");		
	}
	
	//금액에 맞는 로또 생성 메서드
	public void getLotto(int money) {
		Set<Integer> lottoSet = new HashSet<>();
		
		int num = money/1000; //로또 구매 개수
		
		System.out.println();
		System.out.println("로또는 아래와 같습니다");
		
		for(int i=1; i<=num; i++) { //로또 장수 
			while(lottoSet.size()<6) { //로또 번호 생성
				lottoSet.add((int)(Math.random()*45+1)); //1~46범위의 숫자를 set에 저장, 동일 숫자는 저장되지 않음
			}
			ArrayList<Integer> lottoList = new ArrayList<>(lottoSet);//ArrayList 생성자에는 ArrayList로 변환가능한 객체 전달하면 변환된 객체 반환
			Collections.sort(lottoList);//값 크기에 따라 정렬된 list 반환
			System.out.println("로또번호 "+ i + ":" + lottoList);
			lottoSet.clear();
		}
	}
	
	public static void main(String[] args) {		
		new LottoStore().lottoStoreStart();
	}

}






