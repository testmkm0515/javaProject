package threads.name;

public class ThreadNameEx {

	public static void main(String[] args) {
		// main을 포함한 모든 스레드는 이름을 부여 받음(개발자가 명시적으로 이름 설정도 가능)
		Thread mainThread = Thread.currentThread(); //main 메서드(쓰레드)의 참조가 반환
		System.out.println("프로그램 시작 스레드 이름 : "+ mainThread.getName());
		
		ThreadA threadA= new ThreadA();
		System.out.println("작업 스레드이름:"+ threadA.getName());
		threadA.start();
		
		ThreadB threadB= new ThreadB();
		System.out.println("작업 스레드이름:"+ threadB.getName());
		threadB.start();		

	}

}
