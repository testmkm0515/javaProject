package recursion;

import java.util.Scanner;

public class Hanoi {

	public static void main(String[] args) {
		// 하노이의탑 구현
		Scanner sc = new Scanner(System.in);
		System.out.println("하노이의 탑");
		System.out.print("원반 개수 : ");
		int n = sc.nextInt();
		
		hanoi(1,2,3,n); //1번 기둥 원반 n개를 3번 기둥으로 옮김, 2번 기둥 사용 가능
	}
	
	static void hanoi(int from, int m, int to, int n) {
		System.out.printf("f:%d m:%d t:%d\n", from, m, to);
		if(n==0) return;
		
		hanoi(from,to,m, n-1);
		System.out.printf("원반 [%d]을 %d에서 %d로 이동\n",n,from,to);
		hanoi(m,from,to,n-1);
		
	}

}
