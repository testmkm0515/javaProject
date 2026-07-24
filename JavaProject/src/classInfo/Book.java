package classInfo;

public class Book {
	String title;
	String author;
	int price;
	
	// 생성자
	// 매개변수가 없는 생성자
	public Book() {
		//클래스에 여러개의 생성자가 있는 경우 특정 클래스 생성자 에서 다른 생성자 호출 가능
		this("자바스크립트","이몽령",22000); //한 생성자 처리코드에서 다른 생성자 호출
	}
	
	// 매개변수가 있는 생성자
	public Book(String t, String a, int p) {
		title = t;
		author = a;
		price = p;
	}
	
	// 일반 메소드
	public void show() {
		System.out.println("도서명 : "+title);
		System.out.println("저자 : "+author);
		System.out.println("가격 : "+price);
	}
}
