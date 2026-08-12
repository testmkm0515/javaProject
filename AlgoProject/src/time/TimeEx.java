package time;

public class TimeEx {

	public static void main(String[] args) {
		// 알고리즘의 성능 : 공간자원, 시간자원 사용량에 따라 달라짐
		// 시간자원 : 수행시간 -> 시간 복잡도(수행횟수-> 반복문)
		// 입력 n을 기준으로 몇 번 수행하는가?
		int[] A = {1,2,3,4,5,6,7,8,9,10};
		int count = 0;
		
		int sum = 0;
		for(int i=0; i<10; i++) {
			sum += A[i];
			count++;
		}
		
		System.out.println("실행 횟수 : " + count);
		//실행 횟수 : 10 
		//배열이 입력이므로 입력크기 10->수행횟수 10
		//시간복잡도 T(10) -> 10 T(20) -> 20 
		//T(n) -> n
		TimeEx2.calcTime();

	}
	
	class TimeEx2{
		 static void calcTime() {
			int[] A = {1,2,3,4,5,6,7,8,9,10};
			int count = 0;
			
			int sum = 0;
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					sum += A[i];
					count++;
				}
			}
			System.out.println("실행 횟수 : " + count);
			//시간복잡도 : T(10)->100
			//시간복잡도 : T(n)-> n*n
		}
	}

}
