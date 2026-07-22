package ref;

public class StringEquals {

	public static void main(java.lang.String[] args) {
		// String 클래스 참조변수 선언및 인스턴스 생성 방법 1
		// "문자열" 대입
		// String 클래스는 문자열이 저장되는 변수 1개가 있음 저장 문자열이 동일하면 기존 객체를 사용
		String strVar1="신민수"; //String클래스의 객체 인스턴스 생성됨
		String strVar2="신민수"; //위에서 생성한 객체 인스턴스를 참조함
		
		//참조변수에대한  == 연산은 참조주소가 같은지 확인
		if(strVar1==strVar2) { //참조변수가 저장하고 있는 주소가 같은지를 확인
			System.out.println("strVar1과 strVar2는 참조가 같음");
		}else {
			System.out.println("strVar1과 strVar2는 참조가 다름");
		}
		
		//참조되는 데이터(문자열)이 같은지 확인하기 위해서는 String class가 제공하는 메소드 equals() 사용
		if(strVar1.equals(strVar2)) {
			System.out.println("strVar1과 strVar2는 문자열이 같음");
		}

		// String 클래스 참조변수 선언및 인스턴스 생성 방법 2
		// new 메모리 할당 생성자 함수 통해서 초기문자열 지정
		String strVar3 = new String("신민수");
		String strVar4 = new String("신민수");

		//참조변수에대한  == 연산은 참조주소가 같은지 확인
		if(strVar3==strVar4) { //참조변수가 저장하고 있는 주소가 같은지를 확인
			System.out.println("strVar3과 strVar4는 참조가 같음");
		}else {
			System.out.println("strVar3과 strVar4는 참조가 다름");
		}
		
		//참조되는 데이터(문자열)이 같은지 확인하기 위해서는 String class가 제공하는 메소드 equals() 사용
		if(strVar3.equals(strVar4)) {
			System.out.println("strVar3과 strVar4는 문자열이 같음");
		}

	}

}




