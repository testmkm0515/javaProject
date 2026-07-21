package variable;

public class DataType {

	public static void main(String[] args) {
		// 정수타입 : 기본 타입 int, long 형은 기본타입이 아니기 때문에 리터럴 뒤에 l /L 추가해야 함
		
		// 100은 어떤 타입이던 표현가능한 리터럴이므로 long에 넣을 때 l/L 없어도 됨
		int four = 100; //4byte
		long fourD = 100; // 8byte
		
		//100010001000100 4byte로도 표현 불가능한 가중치의 정수임 -4byte로 표현하려고 해서 오류가 발생
		//4byte 표현하지 말고 8byte로 처리하도록 l/L추가해야 함
		long longValue = 100010001000100L;
		System.out.println(longValue); System.out.println(four);
		System.out.println("===================================================");

		
		// 문자타입 변수 선언
		char a = 'A'; //문자A
		char b = '\u0041'; //문자A의 유니코드 값
		char c = 65; //문자A의 아스키코드값
		
		System.out.println(a);System.out.println(b);System.out.println(c);
		System.out.println("===================================================");
		
		//실수 타입 : 소수점이 있는 실수값을 저장하기 위한 타입
		//float(4byte) / double(8byte) -> 실수의 기본 타입
		//기본타입은 리터럴을 표현할 때 준비하는 크기를 의미함
		//double이 기본타입이므로 리터럴은 8byte로 처리됨
		double avg = 88.5; //8byte 리터럴을 8byte 변수에 대입(동일크기이므로 문제 없음)
		//float avg1 = 88.5; //8byte 리터럴을 4byte 변수에 대입(큰 타입을 작은타입에 넣어서 문제가 생김)
		float avg2 = 88.5f; //실수 리터럴 8byte가 아닌 4byte로 처리 후 4byte 변수에 대입(오류 없이 처리)
		
		double doubleValue = 0.1234567890123456789;
		float floatValue = 0.1234567890123456789f;
		
		System.out.println("doubleValue : " + doubleValue); //double 타입이 더 정밀함
		System.out.println("floatValue : " + floatValue);
		
		//실수의 지수 표현
		System.out.println("===================================================");
		
		int var1 = 3000000;
		double var2 = 3000000;
		double var3 = 3e6;
		float var4 = 3e6f;
		double var5 = 2e-3;
		
		System.out.println(var1);
		System.out.println(var2);
		System.out.println(var3);
		System.out.println(var4);
		System.out.println(var5);
		System.out.println("===================================================");
		//문자열 : 참조타입 String -> 큰따옴표 이용 문자열 리터럴을 생성하고 String 타입 변수에 저장
		//기본 변수 : 값 저장 , 참조형 변수(문자열 등) : 값이 있는 메모리의 주소 저장
		String name = "홍길동"; //문자열 홍길동은 메모리 특정공간에 저장되고 name 변수에는 홍길동이 저장된 시작주소가 저장됨
		String addr = "서울시 강남구 역삼동";
		
		//논리형(boolean) 타입
		boolean booleanValue = true;
	}

}








