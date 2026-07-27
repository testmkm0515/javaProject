package extendsex.tostring;

public class Employee {
	private String empNo, name, part; //사번, 성명, 부서
	
	public Employee(String empNo, String name, String part) {
		this.empNo = empNo;
		this.name = name;
		this.part = part;
	}
	//Object 클래스에 의해 자동 상속되는 toString() 메서드가 있음
	//클래스 인스턴스 출력 코드나 출력과 관련된 코드인걸로 판정되면 객체를 문자열로 변경시켜주는 역할
	//상속되어지는 메서드기 때문에 클래스 내용에 맞게 재정의해서 사용
	
	//상속받은 메서드 재정의 의미 - Object 클래스로부터 자동 상속됨
	//toString()메서드는 호출 없이 인스턴스가 출력과 관련된 코드에 사용되면 자동 호출됨
	@Override
	public String toString() {
		return empNo + "\t|" + name + "\t|" + part;
	}
}
