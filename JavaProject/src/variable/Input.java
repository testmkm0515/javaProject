package variable;
//외부 라이브러리 사용 : import 라이브러리패키지명.클래스명
import java.util.Scanner;

public class Input {

	public static void main(String[] args) {
		Scanner sc ;
		sc = new Scanner(System.in); //현재 사용중인 컴퓨터의 기본입력장치(키보드)를 통해 입력된 값을 전달
		
		int num1, num2;
		
		System.out.print("첫번째 숫자 입력 : ");
		num1 = sc.nextInt(); //사용자가 키보드로 입력하는 값(문자)을 받아 정수로 변환 후 반환 요청
		//변환오류 일어날 수 있음
		System.out.println();//콘솔 커서 한칸 아래로 이동
		System.out.println("입력한 숫자 : " + num1);
		
		sc.close();

	}

}
