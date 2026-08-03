package threads.extendsthread;

public class BeepPrintEx {

	public static void main(String[] args) {
		// Thread를 상속받은 하위 클래스 객체 생성 : Thread type으로 생성
		Thread thread = new WorkerThread();
		thread.start();
		
		for(int i=0; i<5; i++) {
			System.out.println("띵");
			try {Thread.sleep(500);}catch(Exception e) {}
		}		
		

	}

}
