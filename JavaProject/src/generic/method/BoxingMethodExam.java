package generic.method;

public class BoxingMethodExam {

	public static void main(String[] args) {
		Box<Integer> box1 = Util.<Integer>boxing(100); //boxing 메서드에 의해 box 객체 반환
		int intValue = box1.get();
		System.out.println(intValue);
		
		Box<String> box2 = Util.boxing("홍길동"); //문자열 전달해서 추정
		String strValue = box2.get();
		System.out.println(strValue);

	}

}
