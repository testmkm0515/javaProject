package threads.name;

public class ThreadB extends Thread {
	//명시적으로 쓰레드 이름 설정 코드 없음
	@Override
	public void run() {
		for(int i=0; i<2; i++) {
			System.out.println(getName()+"가 출력한 내용");//쓰레드 이름 출력
		}
	}
}
