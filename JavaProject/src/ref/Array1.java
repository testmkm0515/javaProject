package ref;
import java.util.Scanner;

public class Array1 {

	public static void main(String[] args) {
		// 배열 원소값 입력받아 처리 출력
		Scanner sc = new Scanner(System.in);
		int[] score = new int[3];
		int sum=0;
		float avg;
		
		System.out.println("점수입력 : ");
		for(int i=0; i<score.length;i++) {
			System.out.printf("score[%d] : ", i);
			score[i] = sc.nextInt();
		}
		
		for(int i=0; i<score.length;i++) {
			sum += score[i];
		}
		
		avg = (float)sum/score.length; //평균 실수 계산 위해서 sum을 형변환
		
		System.out.println("총합 : " + sum);
		System.out.println("평균 : " + avg);
		System.out.printf("평균 : %.2f",  avg);

	}

}
