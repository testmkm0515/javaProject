package exam.collection;

//회원 한명의 정보를 저장
//정보는 외부접근 불가능하도록 구성
public class MemberDTO {
	private String memId; //회원번호
	private String memPass; //회원비번
	private String memName;
	private String memPhone;
	private String memAddress;
	
	public MemberDTO(String memId, String memPass, String memName, String memPhone, String memAddress) {
		this.memId = memId;
		this.memPass = memPass;
		this.memName = memName;
		this.memPhone = memPhone;
		this.memAddress = memAddress;
	}

	//필드에 접근하기 위한 메서드(getter/setter)
	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPass() {
		return memPass;
	}

	public void setMemPass(String memPass) {
		this.memPass = memPass;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemPhone() {
		return memPhone;
	}

	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}

	public String getMemAddress() {
		return memAddress;
	}

	public void setMemAddress(String memAddress) {
		this.memAddress = memAddress;
	}
	
	public String toString() {
		return memId+" "+memPass;
	}
	
	
}
