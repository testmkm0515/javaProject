package extendsex2;

public class Child2 extends extendsex.Parent{
	private int c;
	
	public void setChild() {
		//p=10; //The field Parent.p is not visible(private이어서 상속되지 않음)
		setParent(); //public 메소드이므로 상속됨
		c=20;
		p3=50; //p3가 public 이므로 패키지가 달라도 상속되어짐
	}
	
	public void showChild() {
		// 상속받은 클래스에서 super클래스 상속된 기능 사용 가능
		//showParent(); //부모 클래스 메소드지만 public이 아니므로 상속되지 않음(패키지가 다름)
		//System.out.println("부모 클래스 p2 : " + p2); //자식 클래스에서 부모 클래스 필드 접근 : default접근제한 패키지가 다름
		System.out.println("자식 클래스 c : " + c);
	}	
}
