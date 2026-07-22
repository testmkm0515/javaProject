package loop;

public class Continue {

	public static void main(String[] args) {
		// continue : 현재 반복중인 문장 수행 중단 후 다음 반복을 진행
		for(int i=1; i<=10; i++) {
			if(i%2==0) {
				continue; //i가 if 조건에 참이면 아래 문장 수행하지 않고 반복 증감하러 올라감
			}
			System.out.println(i);
		}

	}

}
