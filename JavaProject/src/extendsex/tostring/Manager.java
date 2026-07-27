package extendsex.tostring;

public class Manager extends Employee {
	//매개변수가 있는 생성자만 super class가 명시하고 있는 경우 명시적으로 생성자 호출을 필요로 함
	
	private String position;
	
	public Manager(String empNo, String name, String part,String position) {
		super(empNo, name, part);
		this.position = position;
	}
	
	@Override
	public String toString() { //Manager 본연 필드 값 뿐만 아니라 일반적인 사원 정보까지 출력
		//super 참조 : 상속받은 상위클래스 인스탄스를 의미
		return super.toString() + "\t|"+position;
	}
}
