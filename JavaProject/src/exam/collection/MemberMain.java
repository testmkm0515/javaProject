package exam.collection;

import java.util.Scanner;
public class MemberMain {

	public static void main(String[] args) {
		// 회원관리 모듈 사용 예시
		
		// 회원 가입
		// 회원 가입 위한 정보 입력 받기
		String id, pass, name, phone, address;
		Scanner sc = new Scanner(System.in);
		MemberDTO dto = null;
		IMemberDAO idao = null;
	
		//회원등록
		//회원 정보 입력 받기
		System.out.println("회원정보를 입력합니다");
		System.out.println("id 입력 : ");
		id =sc.next();
		System.out.println("pass 입력 : ");
		pass =sc.next();
		System.out.println("이름 입력 : ");
		name =sc.next();
		System.out.println("전화번호 입력 : ");
		phone =sc.next();
		System.out.println("주소 입력 : ");
		address =sc.next();
		//1. dto 객체 생성
		dto = new MemberDTO(id,pass,name,phone,address);
		idao = new MemberDAO();
		idao.insertMember(dto);
		idao.insertMember(dto);
		
		/**
		//1명 회원 정보 조회
		System.out.print("조회할 id 입력 : " );id = sc.next();
		memDto = dao.seacrchMember(id);
		if(!(memDto==null)) {
			System.out.println(memDto.getMemId());
			memDto.getMemPass();
			memDto.getMemName();
			memDto.getMemPhone();
			memDto.getMemAddress();
		}else {
			System.out.println(id + "에 해당하는 회원 정보는 조회되지 않습니다");
		}
		**/
		
		

	}

}
