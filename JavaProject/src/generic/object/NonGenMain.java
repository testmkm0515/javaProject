package generic.object;

public class NonGenMain {

	public static void main(String[] args) {
		// 모든 타입의 데이터를 필드에 저장하는 Box 클래스 사용 예시
		// 여러 박스에 타입이 서로 다른 상품 저장
		Box box = new Box();
		box.set("홍길동"); //자동형변환 String->Object
		
		Box box1 = new Box();
		box1.set(7); //자동형변환 int->Object
		
		Box box2 = new Box();
		box2.set(3.14);//자동형변환 double->Object
		
		// 각 박스에서 상품을 추출
		// 문자열 상품
		String name = (String)box.get(); //Object->String 변환 불가오류(강제 타입 변환)
		
		// 정수 박스
		int no = (int)box1.get();
		
		// 실수 박스
		double pi = (double)box2.get();		

	}

}
