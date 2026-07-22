package loop;

public class DoWhile {

	public static void main(String[] args) {
		// do~while은 조건검사를 나중에 진행 : 최소 1번 수행, while/for 조건검사를 우선 수행 : 최소 0번 수행
		int i=100;
		while(i<=10) {
			System.out.println("최소 0번 수행");
			System.out.println(i);
			i++;
		}
		
		i=100;
		do {
			System.out.println("최소 1번 수행");
			System.out.println(i);
			i++;
		}while(i<=10);
				

	}

}
