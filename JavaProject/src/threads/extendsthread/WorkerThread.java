package threads.extendsthread;

import java.awt.Toolkit;

//Thread 클래스를 상속받은 하위 클래스
public class WorkerThread extends Thread{
	@Override
	public void run() {
			Toolkit toolkit = Toolkit.getDefaultToolkit(); 

			for(int i=0; i<5; i++) {
				toolkit.beep();
				try {Thread.sleep(500);}catch(Exception e) {}
			}		
		}	
		
	}
	

