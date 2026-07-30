package api.stringapi;

import java.io.IOException;

public class KeyboardToStringEx {

	public static void main(String[] args) throws IOException{ //System.in.read(bytes) 요구에 의해 예외처리
		// 키보드로부터 입력받은 byte 코드를 문자열로 변환
		byte[] bytes = new byte[100];
		
		System.out.print("입력 : ");
		int readByteNo = System.in.read(bytes); //키보드로부터 입력한 값은 bytes 배열에 저장
		
		System.out.println(readByteNo + "바이트"); //값 입력 후 enter키를 클릭하면 입력된값 뒤에 \r\n 두 값이 전달됨
		
		String str = new String(bytes,0,readByteNo-2);
		System.out.println(str);
 
	}

}
