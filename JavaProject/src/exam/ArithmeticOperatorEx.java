package exam;
import java.util.Scanner;
import java.text.DecimalFormat;

public class ArithmeticOperatorEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		// 사용할 모든 변수 먼저 선언만 해놓고
		int kor, eng, math, total; 
		double average;
		
		System.out.print("국어 점수 입력 : ");
		kor = sc.nextInt();
		
		System.out.print("영어 점수 입력 : ");
		eng = sc.nextInt();
		
		System.out.print("수학. 점수 입력 : ");
		math = sc.nextInt();	
		
		System.out.println("==================");	
		total = kor + eng + math;
		average = total / 3.0;
		
		//소수점 이하 자리수 두자리로 조정
		DecimalFormat df = new DecimalFormat("0.00");
		
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + df.format(average));
		
		sc.close();
	}

}
