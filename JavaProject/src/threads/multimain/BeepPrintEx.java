package threads.multimain;

import java.awt.Toolkit;

public class BeepPrintEx {

	public static void main(String[] args) {
		// 멀티 스레드 사용 예시
		// main 스레드 서브 스레드1 : 2개 스레드 구성
		
		/** 스레드 구현 객체 외부 클래스로 생성
		// 서브 스레드 생성위해 Runnable 인터페이스 참조변수 = 구현객체
		Runnable beepTask = new BeepTask(); //Runnable 객체 구현
		// 기존 Thread api 클래스 객체 활용으로 서브 스레드 생성(생성자에 Runnable 객체 전달)
		Thread thread = new Thread(beepTask);
		**/
		
		/** 스레드(Runnable) 구현객체를 익명 구현객체로 사용 
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit(); 

				for(int i=0; i<5; i++) {
					toolkit.beep();
					try {Thread.sleep(500);}catch(Exception e) {}
				}		
			}
		});
		**/
		
		/** 람다식 사용 : 람다식 구현 블럭에 스레드 실행 코드 모듈을 코딩 **/
		Thread thread = new Thread(()->{
			//현재 thread가 실행할 코드 블럭
			Toolkit toolkit = Toolkit.getDefaultToolkit(); 

			for(int i=0; i<5; i++) {
				toolkit.beep();
				try {Thread.sleep(500);}catch(Exception e) {}
			}			
		});
		
		//서브 스레드 실행(우선 순위에 따라 실행시점이 다름)
		thread.start();
		
		//메인 스레드 작업
		//띵 문자 5번출력하는 코드
		for(int i=0; i<5; i++) {
			System.out.println("띵");
			try {Thread.sleep(500);}catch(Exception e) {}
		}	
		
		//비프음 발생시키면서 동시에 프린팅

	}

}
