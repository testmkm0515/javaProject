package generic.multi;

public class ProductExample {

	public static void main(String[] args) {
		// multi generic
		Product<Tv,String> product1 = new Product<Tv,String>(); 
		product1.setKind(new Tv());
		product1.setModel("smart TV");
		
		Tv tv = product1.getKind();
		System.out.println(product1.getModel());
		
		
		Product<Car,String> product2 = new Product<>(); //생성자 부분 타입파라미터 생략
		product2.setKind(new Car());
		product2.setModel("디젤");
		
		Car car = product2.getKind();
		System.out.println(product2.getModel());

	}

}
