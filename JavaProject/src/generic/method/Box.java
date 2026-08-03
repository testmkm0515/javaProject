package generic.method;

//generic 타입 클래스 구현 - T는 아직 결정되지 않은 타입
//결정되어질 때 어떤 타입이 와도 무방
public class Box<T> {
	private T product;
	
	public void set(T product) {
		this.product = product;
	}
	
	public T get() {
		return this.product;
	}
}
