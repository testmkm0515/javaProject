package extendsex.emp;

//매니저는 사원이면서 관리자
//모든 관리자는 사원, 모든 사원은 관리자가 아님
public class Manager extends Employee {
	private String position;
	
	//입력 받아서 멤버 필드 값 설정
	public void setManager() {
		setEmployee(); //일반적인 사원정보 저장
		System.out.print("직위입력 : ");
		position = sc.next(); //sc 필드 : Employee에서 상속 받음
	}
	
	//멤버 필드값 출력
	public void showManagerInfo() {
		//일반적인 사원 정보 출력
		showEmpInfo();
		//매니저 고유 정보 출력
		System.out.println("직위 : " + position);
	}
}
