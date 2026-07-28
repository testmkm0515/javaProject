package extendsex.poly2;

public class DriverEx {

	public static void main(String[] args) {
		// 매개변수의 다형성
		Driver driver = new Driver();
		
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		
		//drive 메소드의 매개변수가 super class 타입이므로 다형성을 활용
		driver.drive(bus); //파라미터가 superclass로 형변환 발생 
		driver.drive(taxi);

	}

}
