package variable;

public class CastingExample {

	public static void main(String[] args) {
		// 강제 타입 변환
		int intValue = 44032;
		char charValue = (char)intValue; //강제형변환 기호 : (타입)
		System.out.println(charValue);
		
		intValue = 103029770;
		byte byteValue = (byte)intValue;
		System.out.println(byteValue); //데이터손실발생 - 원래데이터가 유지되지 않음
		
		double doubleValue = 3.14;
		intValue = (int)doubleValue;
		System.out.println(intValue); //데이터손실발생 - 소수점이하 삭제
	}

}
