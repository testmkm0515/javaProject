package extendsex.tostring;

public class EmpEx {

	public static void main(String[] args) {
		// 객체 인스턴스 생성 후 인스턴스 변수값을 출력
		Employee emp1 = new Employee("1234", "홍길동", "마케팅");
		Employee emp2 = new Employee("5678", "이몽룡", "영업부");
		
		//객체 참조 변수 값 출력 - toString()이 자동 호출
		System.out.println(emp1);
		System.out.println(emp2);
		System.out.println(emp1.toString());
		
		//Employee를 상속받은 Manager 클래스 객체 인스턴스 생성
		Manager mg = new Manager("1234","홍길동","마케팅","대리");
		System.out.println(mg); //toString 자동호출
	}

}
