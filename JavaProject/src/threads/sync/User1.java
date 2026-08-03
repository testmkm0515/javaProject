package threads.sync;

//thread로 등록할 클래스
public class User1 extends Thread {
	private Calculator2 calculator; //공통 사용 객체에 대한 필드
	
	public void setCalculator(Calculator2 calculator) {
		this.setName("User1");
		this.calculator = calculator;
	}
	
	@Override
	public void run() {
		calculator.setMemory(100);
	}
}
