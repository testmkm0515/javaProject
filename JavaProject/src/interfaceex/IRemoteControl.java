package interfaceex;

public interface IRemoteControl {
	// 상수필드 선언 : 선언과 동시에 반드시 초기화
	// [public static final] 데이터타입 필드명 = 값;
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	// 추상메소드 선언 : public abstract 는 생략해도 됨
	void turnOn();
	void turnOff();
	void setVolume(int volume);
	
	// 디폴트 메소드 선언 : 실행블록을 가지고 있는 메소드
	// default 키워드를 반드시 붙여야 함
	// 기본적으로 public 접근제한(생략해도 컴파일러가 public으로 설정)
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리합니다");
		}else {
			System.out.println("무음 해제합니다");
		}		
	}
	
	// 정적 메소드 선언 : 인터페이스명을 이용해서 공용 사용
	static void changeBattery() {
		System.out.println("건전지를 교환합니다");
	}
	
}




