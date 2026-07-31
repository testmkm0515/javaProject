package api.wrapper;

public class StringToPrimitiveValue {

	public static void main(String[] args) {
		// 문자열 파싱 후 해당 기본 타입으로 변환하는 메서드 : parse+기본타입명
		int value1 = Integer.parseInt("10");
		//int value1_1 = Integer.parseInt("10.5");//NumberFormatException
		double value2 = Double.parseDouble("3.14");
		boolean value3 = Boolean.parseBoolean("true");
		System.out.println(value1+" "+value2+" "+ value3);

	}

}
