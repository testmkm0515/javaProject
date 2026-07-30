package api.stringapi;

public class StringMethod {

	public static void main(String[] args) {
		// charAt() : 문자열의 특정 위치(index)의 문자(char)를 반환
		System.out.println("010624-1230123".charAt(7));
		if("010624-1230123".charAt(7)=='1') {
			
		}
		// getBytes() : 문자열을 byte 배열로 반환
		String str = "안녕하세요";
		byte[] bytes1 = str.getBytes(); //문자열을 byte 배열로 반환 : 영문 1 byte, 한글 3 byte
		System.out.println("str 저장된 문자열의 길이는 ? " + str.length() +
				"\nstr 저장 문자열의 byte배열 원소수는 "+bytes1.length);
		
		//byte배열을 문자열로 변환
		String str2 = new String(bytes1);
		System.out.println(str2);

	}

}
