package threads.priority;

public class ThreadPriority {

	public static void main(String[] args) {
		// 10개의 Thread 생성 동시 실행 - 10번 thread는 우선순위 높게 나머지는 우선순위 낮게 설정
		for(int i=1; i<=10; i++) {
			Thread thread = new CalcThread("thread"+i);
			if (i!=10) {
				thread.setPriority(Thread.MIN_PRIORITY);
			}else { //i가 10인경우
				thread.setPriority(Thread.MAX_PRIORITY);
			}
			thread.start();
		}

	}

}
