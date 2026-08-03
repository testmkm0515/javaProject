package threads.sync;

public class User2 extends Thread{
	private Calculator2 calculator; //공통 사용 객체에 대한 필드
	
	public void setCalculator(Calculator2 calculator) {
		this.setName("User2");
		this.calculator = calculator;
	}
	

	public void run() {
		calculator.setMemory(50);
	}
}
