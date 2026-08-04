package exam.collection;

import java.util.ArrayList;
import java.util.List;

public class MemberDAO implements IMemberDAO{
	private List<MemberDTO> listData = new ArrayList<>(); //회원 정보 저장소로 활용
	
	@Override
	public void insertMember(MemberDTO dto) {
		// 회원가입로직 : 동일 id가 있는지 확인해서 있으면 회원가입 불가, 없으면 회원가입 
		// 가입할 회원의 id 추출

		
		// 회원정보들이 저장된 listData의 원소들 중 memId값이 tmpId와 동일한 원소가 있는지 확인
		// 해당 원소 있으면 반환, 없으면 null 반환
		// List.stream() : 컬렉션에 저장된 엘리먼트를 하나씩 순히하면서 뒤 연산을 진행해주는 코드 패턴
		// Stream<T> 타입을 반환
		// 동일 id가 있으면 dto 객체 반환, 없으면 null
		String tmpId = dto.getMemId();
		MemberDTO optDto =listData.stream().filter(member -> member.getMemId().equals(tmpId))
		                 .findFirst().orElse(null);
		if(optDto != null ) {
			System.out.println("회원가입 실패 : 동일 ID의 회원이 있습니다");
		}else {
			listData.add(dto);
			System.out.println("회원가입 성공");
		}
		
	}

	@Override
	public void deleteMember(String memId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<MemberDTO> getAllMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMember(MemberDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemberDTO seacrchMember(String memId) {
		// TODO Auto-generated method stub
		return null;
	}

}
