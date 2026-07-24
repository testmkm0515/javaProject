package classInfo;

public class Constructor {
	int x;
	int y;
	// 생성자가 없음
	// 컴파일러가 기본 생성자 포함시켜 줌 : Constructor(){} 
	//객체 생성 시 new Constructor();
	}

class Constructor1 {
	int x;
	int y;
	
	//매개변수가 없는 명시적 생성자, 컴파일러는 생성자를 포함시키지 않는다
	//객체 생성 시 new Constructor1();
	public Constructor1() {
		x=100;
		y=200;
	}
}	

class Constructor2 {
		int x;
		int y;
		
		//매개변수가 있는 명시적 생성자, 명시적 생성자가 있으면 컴파일러는 생성자를 포함시키지 않는다
		//객체 생성 시 new Constructor2(10,20);
		//new Constructor2() : 기본 생성자 포함시키지 않으므로 이 방식으로는 객체 생성 불가능
		public Constructor2(int a, int b) {
			x=a;
			y=b;
		}	
}

class Constructor3 {
	int x;
	int y;
	
	//매개변수가 있는 명시적 생성자, 명시적 생성자가 있으면 컴파일러는 생성자를 포함시키지 않는다
	//객체 생성 시 new Constructor2(10,20);
	//new Constructor3() : 객체 생성 가능
	public Constructor3() {
		x=10;
		y=20;
	}
	public Constructor3(int a, int b) {
		x=a;
		y=b;
	}	
}
