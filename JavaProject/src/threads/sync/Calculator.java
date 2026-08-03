package threads.sync;

//공통 객체로 사용할 클래스
public class Calculator {
	private int memory;
	
	public int getMemory() {
		return memory;
	}
	
	//memory 필드의 수정과 조회가 한번에 발생하는 메소드, 공통사용하는 경우 한 스레드가 메소드 사용이 종료되기전
	//다른 스레드가 메서드 사용을 진행할 수 있음
	//동기화가 처리되어 있지 않아서 원하지 않는 결과가 발생될 수 있음
	public void setMemory(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);			
		}catch(InterruptedException e) {}
		System.out.println(Thread.currentThread().getName()+": " + this.memory);
	}
	}

