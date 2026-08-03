package generic.object;

//box 사용시 어떤 타입에 대해서도 사용할 수 있도록 클래스 구성
public class Box {
	private Object product;
	
	public void set(Object product) {
		this.product = product;
	}
	
	public Object get() {
		return this.product;
	}
}
