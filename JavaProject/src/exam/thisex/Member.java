package exam.thisex;

public class Member {
	//멤버필드
	//접근제한자(생략가능) 데이터타입 변수명;
	String id;
	String name;
	int age;
	String hp;
	String address;
	
	//클래스 생성자 함수
	//this 레퍼런스 현재 객체를 의미 - this 참조변수는 인스턴스별로 독립적으로 생성됨
	public Member(String id, String name, int age, String hp, String address) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.hp = hp;
		this.address = address;
	}
	
	//멤버메서드
	public void showMember() {
		System.out.println("-------- 회원 정보 출력 ----------");
		System.out.println("ID : " + id);
		System.out.println("성명 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("전화 : " + hp);
		System.out.println("주소 : " + address);
	}
	
}










