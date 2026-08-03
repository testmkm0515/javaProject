package generic.method;

public class Util {
	
	//static generic 타입으로 메서드 구현
	//메소드 호출 시 매개변수 전달 받음
	public static <T> Box<T> boxing(T t) {
		Box<T> box = new Box<T>();
		box.set(t);
		return box;
	}
}
