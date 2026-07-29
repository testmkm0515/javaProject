package interfaceex;

public class Television implements IRemoteControl{
	private int volume;

	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다");		
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다");
		
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
		System.out.println("현재 TV 볼륨 : "+this.volume);					
	}
	
	//디폴트 메소드 재정의하지 않음 - 인터페이스 메소드 코드가 컴파일러에 의해 클래스로 복사됨
	
}
