package classInfo;

public class GetterSetter {
	private int speed;
	private boolean stop;
	
	//멤버필드에 값을 저장하기 위한 메소드 : 매개변수
	//setter : set필드명
	public void setSpeed(int speed) {
		this.speed=speed;
	}
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	//멤버필드의 값을 반환하기 위한 메소드
	//getter : get필드명, is필드명(boolean)
	public int getSpeed() {
		return this.speed;
	}
	
	public boolean isStop() {
		return this.stop;
	}
}




