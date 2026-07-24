package classInfo;

public class Computer {
	//매개변수로 배열을 전달받는 메소드 예제
	int sum1(int[] values) {
		int sum=0;
		for(int i=0; i<values.length; i++) {
			sum += values[i];
		}
		return sum;		
	}
	
	//매개변수 리스트 형식으로 구성
	//리스트 형식의 구성 : 매개변수타입 ... 매개변수명
	//... : 호출시 전달된 파라미터의 수에 따라 자동으로 배열 생성
	//2개 파라미터 : 원소가 2개인 배열 생성
	int sum2(int ... values) {
		int sum=0;
		for(int i=0; i<values.length; i++) { //... 형식으로 파라미터 전달 받아도 배열생성되므로 배열연산처리
			sum += values[i];
		}
		return sum;		
	}
}
