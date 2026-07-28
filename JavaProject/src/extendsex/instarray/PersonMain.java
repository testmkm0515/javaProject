package extendsex.instarray;

public class PersonMain {

	public static void main(String[] args) {
		// 3명의 정보를 처리
		Person[] p = new Person[3]; //레퍼런스 배열
		
		System.out.println("****개인 정보 입력****");
		for(int i=0; i<p.length;i++) {
			p[i] = new Person(); //객체 생성 후 배열 원소가 참조, 매개변수가 없는 생성자
			p[i].input();
		}

		System.out.println("****개인 정보 출력****");	
		for(int i=0; i<p.length;i++) {
			p[i].output();
		}
	}

}
