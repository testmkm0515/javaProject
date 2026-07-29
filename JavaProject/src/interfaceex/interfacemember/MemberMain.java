package interfaceex.interfacemember;

import java.util.Scanner;
public class MemberMain {

	public static void main(String[] args) {
		// 회원관리 모듈 사용 예시
		
		// 회원 가입
		// 회원 가입 위한 정보 입력 받기
		Scanner sc = new Scanner(System.in);
		// 회원 정보 참조 객체 변수
		MemberDTO memDto = null;
		
		System.out.println("회원 가입 정보 입력 : ");
		System.out.print("id 입력 : " );String id = sc.next();
		System.out.print("비밀번호 입력 : " );String pass = sc.next();
		System.out.print("이름 입력 : " );String name = sc.next();
		System.out.print("전화번호 입력 : " );String phone = sc.next();
		System.out.print("주소 입력 : " );String address = sc.next();
		
		//1명회원 참조
		memDto = new MemberDTO(id,pass,name,phone,address);
		
		IMemberDAO dao = new MemberDAO();
		dao.insertMember(memDto);
		
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
		
		

	}

}
