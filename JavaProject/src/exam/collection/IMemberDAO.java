package exam.collection;

import java.util.ArrayList;

//회원관리 모듈 구성을 위해 interface에서 회원관리 기능을 정의
public interface IMemberDAO {
	
	//추상메소드 선언
	//1명 회원정보 등록 : 1명의 회원 정보를 받아서 DB에 저장하고 종료(매개변수 있음 반환값 없음)
	public void insertMember(MemberDTO dto);

	public void deleteMember(String memId);

	public ArrayList<MemberDTO> getAllMember();

	public void updateMember(MemberDTO dto);

	public MemberDTO seacrchMember(String memId);
	
}









