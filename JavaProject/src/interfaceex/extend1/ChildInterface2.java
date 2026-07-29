package interfaceex.extend1;

public interface ChildInterface2 extends ParentInterface{
	//상속받은 default 메서드 재정의 - default 키워드 반드시 사용
	@Override
	public default void method2() {
		 System.out.println("c2-m2()");
	}
	public void method3();
}
