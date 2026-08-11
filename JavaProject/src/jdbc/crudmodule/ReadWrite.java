package jdbc.crudmodule;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ReadWrite {
	//사용자로부터 입력에 사용하는 메서드
	//insert, update 사용
	public static StudentDTO getStdInfo(Scanner sc, String stdNo) {
		StudentDTO dto = null;
		try {
			if(stdNo==null) {
			System.out.println("학생 정보 등록");
			System.out.print("학번 입력 : ");
			stdNo = sc.nextLine();
			}
			
			System.out.print("성명 입력 : ");
			String stdName = sc.nextLine();
			
			System.out.print("학년 입력 : ");
			int stdYear = sc.nextInt();
			
			sc.nextLine();
			
			System.out.print("주소 입력 : ");
			String stdAddress = sc.nextLine();
			
			System.out.print("생년월일 입력 : ");
			String stdBirthday = sc.nextLine();	
			
			//입력한 문자열을 Date 타입으로 변환
			SimpleDateFormat fm = new SimpleDateFormat("yyyy-mm-dd");
			Date stdBirth = fm.parse(stdBirthday);
			
			System.out.print("학과번호 입력 : ");
			String dptNo = sc.nextLine();	
			
			dto = new StudentDTO(stdNo, stdName, stdYear, stdAddress, stdBirth, dptNo);
			
			
		}catch(Exception e) {
			System.out.print("입력오류");
			e.printStackTrace();
		}
		return dto;
	}
	
	/////////////////////////////////////////////////////////////
	/// 출력 메소드 - dao에서 select된 결과는 ArrayList 타입이거나 StudentDTO 타입
	
	public static void writeStdInfo(ArrayList<StudentDTO> stdList) {
		System.out.println("----- 전체(과별) 학생 정보 조회 ------");
		System.out.format("%-10s\t %-10s\t %-4s %-20s \t%13s %5s\n", 
				"학번", "성명", "학년", "주소", "출생일", "학과번호");	
		
		for(StudentDTO dto : stdList) {
			String stdNo = dto.getStdNo();
			String stdName = dto.getStdName();
			int stdYear = dto.getStdYear();
			String stdAddress = dto.getStdAddress();
			Date stdBirthday = dto.getStdBirth();
			String dptNo = dto.getDptNo();
			
			// 한 행씩 출력 
			System.out.format("%-10s\t %-10s\t %-4d %-20s \t%13s %5s\n", 
					stdNo, stdName, stdYear, stdAddress, stdBirthday, dptNo);
		}		
	}
	
	public static void writeStdInfo(StudentDTO dto) {
		System.out.println("----- 학생 정보 조회 ------");
		System.out.format("%-10s\t %-10s\t %-4s %-20s \t%13s %5s\n", 
				"학번", "성명", "학년", "주소", "출생일", "학과번호");	
			String stdNo = dto.getStdNo();
			String stdName = dto.getStdName();
			int stdYear = dto.getStdYear();
			String stdAddress = dto.getStdAddress();
			Date stdBirthday = dto.getStdBirth();
			String dptNo = dto.getDptNo();
 
			System.out.format("%-10s\t %-10s\t %-4d %-20s \t%13s %5s\n", 
					stdNo, stdName, stdYear, stdAddress, stdBirthday, dptNo);
		
	}
}












