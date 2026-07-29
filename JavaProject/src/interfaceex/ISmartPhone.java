package interfaceex;

//interface 이름은 관례적으로 대문자 I를 앞에 포함시킴 이름의 첫글자도 대문자로 포함
//IAnimal
public interface ISmartPhone {
	//구현클래스에서 필수구현해야 하는 메소드의 원형(선언부)을 나열
	//생성자함수는 포함할 수 없음 - 인터페이스는 객체인스턴스 생성할 수 없음
	
	// 구성요소 1 : 추상메소드
	public void sendCall();
	public void receiveCall() ;
	public void sendSMS();
	public void receiveSMS();
	
	// 구성요소 2 : static final 상수필드
	// 구성요소 3 : 디폴트메소드 : 구현한 메소드
	// 구성요소 4 : static 메소드 : 구현한 메소드
}
