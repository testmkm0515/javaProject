package conditioin;
import java.util.Scanner;

public class Switch {

	public static void main(String[] args) {
		// switch 값이 정수인 경우 예제
		Scanner sc = new Scanner(System.in);
		int year;
		
		System.out.print("학년 입력 : ");
		year = sc.nextInt(); //입력된 문자를 정수로 변환 후 반환(입력 완료인 enter 문자는 처리하지 않음)
		
		switch(year) {
			case 1: System.out.println("1학년");
			case 2: System.out.println("2학년");
			case 3: System.out.println("3학년");
			case 4: System.out.println("4학년");break;
			default: System.out.println("잘못 입력했습니다");
		}		
		sc.nextLine(); //nextInt()가 처리하지 않은 enter 문자 지우기
		// 값이 문자열인 경우 예제
		System.out.print("직급을 입력하세요");
		String position = sc.nextLine();//nextLine()은 공백을 포함한 문자열을 입력받는다(enter문자도 포함됨)
		
		switch(position) {
			case "부장":
				System.out.println("700만원"); 
				break;
			case "과장":
				System.out.println("500만원");
				break;
			case "대리":
				System.out.println("300만원");
				break;
			default :
				System.out.println("200만원");
		}
		
		char grade = 'C';
		switch(grade) {
			case 'A':
			case 'B':
				System.out.println("참 잘하였습니다"); break;
			case 'C':
			case 'D':
				System.out.println("좀 더 노력하세요"); break;	
			case 'F':
				System.out.println("재수강"); break;
			default :
				System.out.println("잘못된 학점");		}

	}

}
