package api.strintoken;

import java.util.StringTokenizer;

public class StringTokenMethod {

	public static void main(String[] args) {
		// StringTokenizer 클래스의 메서드
		// int countTokens() : 꺼내지 않고 남아있는 토큰의 수를 반환
		// String nextToken() : tokenizer 클래스 객체에 저장된 토큰들 중 하나를 꺼내옴
		// boolean hasMoreToken() : 남아있는 토큰이 있는지의 여부를 반환
		
		String text = "홍길동/이수홍/박연수";
		
		//토큰수를 얻어 for문으로 확인
		StringTokenizer st = new StringTokenizer(text,"/");
		int countTokens = st.countTokens();
		for(int i=0; i<countTokens;i++) {
			String token = st.nextToken();//토큰배열의 시작주소를 참조하고있다가 포인팅 이동 후 해당위치 토큰 반환
			System.out.println(token);
		}
		System.out.println();
		
		//남아 있는 토큰이 있는지 확인 후 while문으로 루핑
		st = new StringTokenizer(text,"/");
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token);
		}
		
		

	}

}
