package generic.multi;

//T : 객체, M : 객체의 모델(종류),String
public class Product<T,M> {
	private T kind;
	private M model;
	
	public T getKind() {
		return kind;
	}
	public void setKind(T kind) {
		this.kind = kind;
	}
	public M getModel() {
		return model;
	}
	public void setModel(M model) {
		this.model = model;
	}
	

}
