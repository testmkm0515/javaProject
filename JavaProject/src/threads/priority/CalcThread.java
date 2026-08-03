package threads.priority;

public class CalcThread extends Thread {
	public CalcThread(String name) {
		setName(name);
	}
	
	@Override
	public void run() {
		System.out.println(getName()+"start");
		for(int i=0; i<200000000;i++) {
			for(int j=0; j<2000; j++) {
				
			}
		}
		System.out.println(getName()+"end");
	}
}
