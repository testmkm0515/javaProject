package generic.gen;

public class GenMain {

	public static void main(String[] args) {
		// 모든 타입의 데이터를 필드에 저장하는 Box 클래스 사용 예시
		// 여러 박스에 타입이 서로 다른 상품 저장 - 객체 인스턴스 생성 시 상품의 타입을 구체화
		Box<String> box = new Box<String>(); //제네릭 타입 T가 String으로 구체화 됨
		box.set("홍길동"); 
		
		Box<Integer> box1 = new Box<Integer>();
		box1.set(7); 
		
		Box<Double> box2 = new Box<Double>();
		box2.set(3.14);
		
		// 각 박스에서 상품을 추출 - 인스턴스 생성 시 타입 구체화 됨
		// 문자열 상품
		String name = box.get(); 
		
		// 정수 박스
		int no = box1.get();
		
		// 실수 박스
		double pi = box2.get();		
	}

}
