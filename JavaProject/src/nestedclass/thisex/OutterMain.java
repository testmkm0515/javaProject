package nestedclass.thisex;

public class OutterMain {

	public static void main(String[] args) {
		// 인스턴스 멤버 클래스 객체 생성 시 바깥 클래스 객체 생성 후 가능
		Outter outter = new Outter();
		Outter.Nested nested = outter.new Nested();
		nested.print();
	}

}
