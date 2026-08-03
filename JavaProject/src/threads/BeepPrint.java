package threads;

import java.awt.Toolkit; //시스템의 자원 정보(화면크기등, 클립보드, 소리재생 등)를 다루는 API
// awt : 자바 GUI를 위한 API

public class BeepPrint {

	public static void main(String[] args) {
		// 자바 프로그램에서 무조건 생성되는 thread : main
		// 기능을 추가 : main 스레드에 포함시킴
		Toolkit toolkit = Toolkit.getDefaultToolkit(); //현재 시스템의 기본설정된 자원을 반환
		
		//아래 두 for문은 순서대로 위에서 아래로 하나씩 진행
		//비프음 5번출력하는 코드
		for(int i=0; i<5; i++) {
			toolkit.beep();
			try {Thread.sleep(500);}catch(Exception e) {}
		}
		
		//띵 문자 5번출력하는 코드
		for(int i=0; i<5; i++) {
			System.out.println("띵");
			try {Thread.sleep(500);}catch(Exception e) {}
		}		

	}

}
