package interfaceex;

public class Audio implements IRemoteControl{
	//멤버필드
	private int volume;
	private boolean mute;

	@Override
	public void turnOn() {
		System.out.println("Audio를 켭니다");		
	}
	@Override
	public void turnOff() {	
		System.out.println("Audio를 끕니다");
	}
	@Override
	public void setVolume(int volume) {
		// 볼륨조절 : 최대치/최소치 비교해서 범위내에서 볼륨 설정
		if(volume>IRemoteControl.MAX_VOLUME) {
			this.volume=IRemoteControl.MAX_VOLUME;
		}else if(volume<IRemoteControl.MIN_VOLUME) {
			this.volume=IRemoteControl.MIN_VOLUME;
		}else {
			this.volume = volume;
		}
		System.out.println("현재 Audio 볼륨 : "+this.volume);		
	}
	
	//default 메소드 재정의 가능(선택)
	//재정의 하는 경우 default 키워드는 쓰지않음
	@Override
	public void setMute(boolean mute) {
		this.mute = mute;
		if(this.mute) {
			System.out.println("Audio를 무음 처리 합니다");
		}else {
			System.out.println("Audio 무음을 해제합니다");
		}
	}
	
	
}











