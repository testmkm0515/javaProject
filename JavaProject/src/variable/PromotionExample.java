package variable;

public class PromotionExample {

	public static void main(String[] args) {
		// 자동 형변환
		byte byteValue = 10;
		int intValue = byteValue; //1byte -> 4byte byteValue의 리터럴이 대입되는 시점에 정수타입으로 확장
		
		char charValue = '가' ;
		intValue = charValue; // 묵시적 자동 형변환 2byte -> 4byte
		
		intValue = 500 ; 
		long longValue = intValue; // 4byte -> 8byte 자동 형변환
		
		double doubleValue = intValue; //작은크기의 정수가 큰크기의 실수로 저장(자동형변환)
		System.out.println(doubleValue);
		
		// 크기가 큰 실수를 정수변수에 저장할 경우 데이터 손실 발생 - 개발자가 결정해야 함(강제타입 변환 필요)
		//intValue = doubleValue; //Type mismatch: cannot convert from double to int

	}

}
