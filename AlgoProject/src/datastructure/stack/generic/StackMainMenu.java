package datastructure.stack.generic;

import java.util.EmptyStackException;
import java.util.Scanner;

public class StackMainMenu {

	public static void main(String[] args) {
		// stack 사용자 인터페이스(메뉴)
		Scanner stdIn = new Scanner(System.in);
		StackGeneric<String> s ;
		
		//스택 구성을 위한 용량 입력
		System.out.println("필요 용량 입력(양수) : ");
		int stackSize = stdIn.nextInt();
		s = new StackGeneric<>(stackSize);
		System.out.println();
		while(true) {
			System.out.println();
			System.out.print("1.push 2.pop 3.peek 4.showStack 5.size 6.Capacity 7.종료");
			
			int menu = stdIn.nextInt(); //enter 키 처리 필요
			if(menu == 7) break;
			stdIn.nextLine();
			String x ;
			switch(menu) {
				case 1 :
					System.out.print("데이터 : ");
					x =stdIn.nextLine();
					try {
						s.push(x);
					}catch(Exception e) {
						System.out.println("스택이 가득 찼습니다");
					}					
					break;
				case 2 :
					try {
						x = s.pop();
						System.out.println("추출한 데이터는 " + x + "입니다");
					}catch(EmptyStackException e) {
						System.out.println("스택이 비어있습니다");
					}					
					break;	
				case 3 :
					try {
						System.out.println("최상단 data : "+ s.peek());
					}catch(Exception e) {
						System.out.println("스택이 비어있습니다");
					}					
					break;	
				case 4 :
					try {
						s.showStack();
					}catch(Exception e) {
						System.out.println("스택이 비어있습니다");
					}					
					break;	
				case 5 :
					System.out.println("스택에 저장된 data 수 : " + s.size());
					break;	
				case 6 :
					System.out.println("스택용량 : " + s.getCapacity());
					break;					
			}
		}
	}

}












