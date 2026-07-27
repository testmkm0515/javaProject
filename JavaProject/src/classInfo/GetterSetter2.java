package classInfo;

public class GetterSetter2 {
	private int speed; //기본값 0으로 초기화
	private boolean stop; //기본값 false로 초기화
	
	
	//이클립스 메뉴통해 자동 추가
	//source - generate getter and setter
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		if(speed < 0) {
			this.speed=0;
		}else {
			this.speed = speed;
		}
	}
	public boolean isStop() {
		return stop;
	}
	
	public void setStop(boolean stop) {
		this.stop = stop;
		this.speed=0;
	}


}
