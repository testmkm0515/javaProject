package interfaceex.multi;

//한개 이상의 인터페이스를 구현하는 클래스 : 다중 인터페이스 구현 객체
//두 인터페이스의 모든 추상메소드를 반드시 구현
public class SmartTelevision implements ISearchable,IRemoteControl{
	private int volume;
	
	@Override
	public void search(String url) {		
		System.out.println(url +"을 검색합니다");
	}

	@Override
	public void turnOn() {
		System.out.println("스마트 TV를 켭니다");		
	}

	@Override
	public void turnOff() {
		System.out.println("스마트 TV를 끕니다");
		
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
		System.out.println("현재 스마트 TV 볼륨 : "+this.volume);					
	}

}
