package extendsex.poly;

public class CarMain {

	public static void main(String[] args) {
		// 다형성예제
		Car car = new Car();
		for(int i=1; i<=5; i++) {
			int problemLocation = car.run();
			
			switch(problemLocation) {
			case 1:
				System.out.println("앞 왼쪽 HankookTire로 교체");
				car.frontLeftTire = new HankookTire("앞왼쪽",15);
				break;
			case 2:
				System.out.println("앞 오른쪽 KumhoTire로 교체");
				car.frontRightTire = new KumhoTire("앞오른쪽",13);
				break;
			case 3:
				System.out.println("뒤 왼쪽 KumhoTire로 교체");
				car.frontRightTire = new KumhoTire("뒤왼쪽",12);
				break;
			case 4:
				System.out.println("뒤 오른쪽 HankookTire로 교체");
				car.frontRightTire = new HankookTire("뒤오른쪽",15);
				break;
			}
		}

	}

}
