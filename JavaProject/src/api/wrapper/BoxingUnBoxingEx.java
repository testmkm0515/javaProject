package api.wrapper;

public class BoxingUnBoxingEx {

	public static void main(String[] args) {
		// Boxing : 기본타입 -> Wrapper타입
		// 생성자
		Integer obj1 = new Integer(100);
		Integer obj2 = Integer.valueOf(200);
		Integer obj3 = Integer.valueOf("300");
		
		//자동 boxing
		Integer obj4 = 400;
		
		// UnBoxing
		int value1 = obj1.intValue();
		int value2 = obj2.intValue();
		int value3 = obj3.intValue();
		// 자동 언박싱
		int value4 = obj4;
		
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);
		System.out.println(value4);
		
		

	}

}
