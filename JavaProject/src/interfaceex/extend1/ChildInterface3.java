package interfaceex.extend1;

public interface ChildInterface3 extends ParentInterface{
	//ParentInterface에서 상속받은 default 메서드 재정의(추상메서드 재선언)
	@Override
	public void method2(); //default메서드를 추상메서드로 재선언(구현객체에서 필수 구현)	
	public void method3();//추상메소드
}
