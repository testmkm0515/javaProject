package api.stringapi;

public class ByteToString {

	public static void main(String[] args) {
		// Byte 타입의 배열을 String() 를 통해 문자열로 변환 예시
		byte[] bytes = {72,101,108,108,111,32,74,97,118,97};
		
		//String 클래스 생성자 
		String str1 = new String(bytes);//bytes 배열 전체원소를 문자로 변환 후 결합해서 문자열 생성
		System.out.println(str1);
		
		//String 클래스 생성자2(배열, 시작인덱스, 몇개원소) 
		String str2 = new String(bytes,6,4);//bytes 배열 원소일부를 문자로 변환 후 결합해서 문자열 생성
		System.out.println(str2);		

	}

}
