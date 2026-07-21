package Operators;

public class BitShiftEx {

	public static void main(String[] args) {
		// << : 왼쪽 shift 오른쪽은 0으로 채워짐
		System.out.println("1 << 3 = " + (1 << 3));
		// >> : 오른쪽 shift 왼쪽은 부호비트(최상위 비트)값으로 채워짐
		System.out.println("8 >> 3 = " + (8 >> 3));
		System.out.println("-8 >> 3 = " + (-8 >> 3));
		// >>> : 오른쪽 shift 왼쪽은 무조건 0으로 채워짐
		System.out.println("-8 >>> 3 = " + (-8 >>> 3));
	}

}
