package api.objectapi;

public class ObjectMethod {

	public static void main(String[] args) {
		// Object.equals() : 객체 비교 메소드
		Object obj1 = new Object();
		Object obj2 = new Object();
		//번지비교 
		System.out.println(obj1.equals(obj2));
		System.out.println(obj1==obj2);
		
		// Object.hashCode() : 객체의 해시코드 반환
		// 객체의 해시코드 : 객체를 식별할 하나의 정수값
		
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		
		// Object.toString() : 객체의 문자정보 리턴(하위 클래스에서 재정의해서 개발자의도의 출력을 진행하도록 함)
		System.out.println(obj1.toString());
		System.out.println(obj2.toString());
		
		// Object.clone() : 객체 복제
		// 배열복제시 활용했음
		
		//Object.finalize() : 객체 소멸자, GC는 객체를 소멸시키기 직전 finalize()를 호출
		//기본적으로 실행내용 없음, 개발자가 객체가 소멸되기 전에 실행할 코드가 있다면 Object.finalize() 재정의
		
		//System.gc() : Garbage Collector 호출, 바로 호출 되지는 않고 메모리 부족하거나 CPU가 한가할 때 JVM에 의해 실행
		//finalize() : 언제 호출될지 모름
		//메서드는 있지만 소멸자를 될 수 있으면 사용하지 말것

	}

}
