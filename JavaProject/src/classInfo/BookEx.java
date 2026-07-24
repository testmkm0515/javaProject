package classInfo;

public class BookEx {

	public static void main(String[] args) {
		// Book 클래스 서로다른 생성자 2개 
		Book b1 = new Book("Java","홍길동",20000);
		Book b2 = new Book();

		System.out.println("*********b1 도서***********");
		b1.show();
		System.out.println("\n*********b2 도서***********");
		b2.show();		
	}

}
