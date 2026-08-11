package jdbc.crudmodule;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentMain {
/*
 * 연습 과제 ( ~ 15:50)
 * 프로그램 실행 테스트 진행 후 오류가 나거나 수정 판단이 되는 코드는 수정하고 기록
 * 
 * getStdInfo(Scanner)메서드에 대해 insert와 update에 대해 학번 입력을 다르게 진행하도록 수정
 * insert(학번입력받기) update(학번입력 없음)
 */
	
	public static void main(String[] args) {
		// 개발코드 프로그램 실행 절차를 기술
		
		IStudentDAO dao = new StudentDAO(); //객체 생성 시 자동으로 db 연결
		
		Scanner sc = new Scanner(System.in);
		String stdNo;
		String dptName;
		String selMenu=null;
		ArrayList<StudentDTO> stdList = null;
		while(true) {
			try {
				System.out.println("===============학생관리 프로그램=============");
				System.out.println("1. 학생정보 등록");
				System.out.println("2. 학생정보 수정");
				System.out.println("3. 학생정보 삭제");
				System.out.println("4. 모든 학생정보 조회");
				System.out.println("5. 개별 학생정보 조회(학번)");
				System.out.println("6. 과별 학생정보 조회(학과명)");
				System.out.println("7. 종료");
				System.out.println("========================================");
				
				System.out.print("메뉴 번호 입력 : ");
				selMenu = sc.nextLine();	
			}catch(Exception e) {
				System.out.println("잘못된 입력입니다. 다시 입력하세요");
			}
			
			switch(selMenu) {
			case "1" :
				dao.insertStudent(ReadWrite.getStdInfo(sc,null));
				break;
			case "2" :
				System.out.println("학번을 입력하세요");
				stdNo = sc.nextLine();
				ReadWrite.writeStdInfo(dao.detailStudent(stdNo)); //기존 저장 정보 출력(확인용)
				dao.updateStudent(ReadWrite.getStdInfo(sc,stdNo)); //update인 경우 학번 전달해서 학번 입력 없이 진행되도록 수정
				break;
			case "3" :
				System.out.println("학번을 입력하세요");
				stdNo = sc.nextLine();
				dao.deleteStudent(stdNo);
				break;
			case "4" :
				stdList = dao.getAllStudent();
				ReadWrite.writeStdInfo(stdList);
				break;
			case "5" :
				System.out.println("학번을 입력하세요");
				stdNo = sc.nextLine();
				ReadWrite.writeStdInfo(dao.detailStudent(stdNo));				
				break;
			case "6" :
				System.out.println("학과명을 입력하세요");
				dptName = sc.nextLine();
				ReadWrite.writeStdInfo(dao.searchStudentDept(dptName));
				break;
			case "7" :
				System.out.println("프로그램을 종료 합니다");
				sc.close();
				System.exit(0); //프로그램 종료
			default : 
				System.out.println("잘못된 입력입니다");
			
			}
		}

	}
}











