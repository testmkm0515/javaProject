package api.objectapi.finalize;

public class FinalizeMain {

	public static void main(String[] args) {
		// 객체 소멸자 호출 예제
		Counter counter = null;
		for(int i=1; i<=50; i++) {
			counter = new Counter(i);
			counter = null; //위에서 생성한 객체가 소멸된다면 재정의한 finalize() jvm에 의해 자동 호출
			System.gc(); //메소드 사용해도 객체가 바로 소멸되지 않음
		}

	}

}
