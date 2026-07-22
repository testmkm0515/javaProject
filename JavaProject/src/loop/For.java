package loop;

public class For {

	public static void main(String[] args) {
		// for(초기식;조건식;증감식){반복문장}
		int i; //main 메소드 내 어디에서든 사용 가능
		for(i=1; i<=10; i++) {
			System.out.println(i);
		}
		System.out.print("i 최종 값 : ");
		System.out.println(i);
		
		for(int j=20; j<=30; j+=2) { //j는 for 문 내부의 지역변수
			System.out.println(j);
		}
		//System.out.print("j 최종 값 : ");
		//System.out.println(j);	
		
		//1~100까지 더한 값을 확인
		//10+5+6+...+100
		//1+2+3+
		int k, sum=0;
		for(k=1;k<=100;k++) {
			// sum=0;
			sum += k;
		}
		
		System.out.println("1~"+(k-1)+" 합 : "+sum);

	}

}
