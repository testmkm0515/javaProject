package extendsex.emp;

import java.util.Scanner;

public class Employee {
	Scanner sc = new Scanner(System.in);
	private String empNo, name, part; //사번, 성명, 부서
	
	//입력 받아 멤버 필드값 설정
	public void setEmployee() {
		System.out.print("사번 입력 : ");
		empNo = sc.next();
		System.out.print("성명 입력 : ");
		name = sc.next();
		System.out.print("부서 입력 : ");
		part = sc.next();		
	}
	
	// 멤버 필드 값 출력
	public void showEmpInfo() {
		System.out.println("\n*************************");
		System.out.println("사번 : "+ empNo);
		System.out.println("성명 : "+ name);
		System.out.println("부서 : "+ part);
	}

}
