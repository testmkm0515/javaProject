package exception;

public class NumberFormatEx {

	public static void main(String[] args) {
	// 문자열을 숫자로 변환할때 발생하는 예외
		String data1 = "100";
		String data2 = "a100";
		
		int value1 = Integer.parseInt(data1);
		int value2 = Integer.parseInt(data2);//NumberFormatException

	}

}
