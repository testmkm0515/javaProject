package loop;

public class ForNested {

	public static void main(String[] args) {
		// for문안에 for문이 포함되는 문장 구조 : 중첩 for
		for(int i=1; i<=3; i++) {
			for(int j=1; j<=5; j++) {
				System.out.print(j + " "); //15번 반복됨
			}
			System.out.println(); //3번반복됨
		}
		
		for(int m=2; m<=9; m++) { //단을 결정
			System.out.println("***** " + m +"단 *****");
			for(int n=1; n<=9; n++) {
				System.out.println(m + "x" + n + "=" + (m*n));
			}
			
		}

	}

}
