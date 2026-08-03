package threads.multimain;

import java.awt.Toolkit;

//Runnable 인터페이스 run 추상메서드 하나가 포함되어 있음
//재정의 할때 스레드가 동작할 코드를 포함시킴
public class BeepTask implements Runnable{
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit(); 

		for(int i=0; i<5; i++) {
			toolkit.beep();
			try {Thread.sleep(500);}catch(Exception e) {}
		}		
	}
	
}
