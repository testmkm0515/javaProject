package ramda.localvar;

public class UsingThisEx {

	public static void main(String[] args) {
		// 람다식 포함 클래스 메소드 호출
		UsingThis usingThis = new UsingThis();
		
		UsingThis.Inner inner = usingThis.new Inner();
		
		//중첩클래스 메소드 호출
		inner.method(500);

	}

}
