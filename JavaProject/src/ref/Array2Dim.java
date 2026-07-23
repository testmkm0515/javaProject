package ref;

public class Array2Dim {

	public static void main(String[] args) {
		// 다차원 배열 : 차원에 따라 [] 수를 증가시킨다 [][] : 2차원 [][][] : 3차원
		int[][] a = new int[3][4]; //선언과 동시할당
		
		//2차원 배열의 초기화 : 선언 + 기억장소할당+원소에 값 저장
		int[][] b = {{1,2,3,4},{5,6,7,8},{9,10,11,12}}; //3행 4열 2차원 배열
		char[][] c = {{'a','b','c'},
					  {'d','e','f'}}; //2행3열
		
		//2차원 배열의 각 원소값 접근해서 출력
		System.out.println(c[0][2]);
		
		for(int i=0;i<2;i++) {
			for(int j=0; j<3; j++) {
				System.out.println(c[i][j]);
			}
		}
		//배열 길이 참조 : 배열.length, 배열[index].length
		for(int i=0;i<c.length;i++) {
			for(int j=0; j<c[i].length; j++) {
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}		
		
		
		//2차원 배열의 행을 접근해서 출력
		for(int i=0; i<c.length; i++) {
			System.out.println(c[i]); //각 행의 원소 모두 출력
		}
		
		//2차원 배열 변수 출력
		System.out.println(c); //[[C@2ff4acd0 -> [[ 2차원 배열

	}

}
