package extendsex.emp;

public class EmpRun {

	public static void main(String[] args) {
		// Manager 정보 저장 및 출력
		Manager mg = new Manager();//서브 클래스 객체 생성
		
		mg.setManager();
		mg.showManagerInfo();

	}

}
