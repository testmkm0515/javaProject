package Operators;

public class IncreaseOperator {

	public static void main(String[] args) {
		// 단항 연산자
		int x=10;
		int y=10;
		int z;
		
		System.out.println("-----------------------------------");
		// 증감연산자 단독으로 사용되면 연산자의 위치는 상관 없음
		x++; //x=x+1
		++x; //x=x+1
		System.out.println(x);
		System.out.println("-----------------------------------");
		// 증감연산자 단독으로 사용되면 연산자의 위치는 상관 없음
		y--; //y=y-1
		--y; //y=y-1
		System.out.println(y);	
		
		//증감연산자 사용시 위치가 중요 : 다른 연산자(대입)와 같이 사용할 경우 증감 연산자 위치가 중요함
		x = 10; y=10;
		
		//증감연산 변수 앞에 사용		
		z = ++x;
		System.out.println("-----------------------------------");
		System.out.println(x);
		System.out.println(z);
		//변수값을 증가시키고 값을 사용함
		
		//증감연산 변수 뒤에 사용		
		z = y++;
		System.out.println("-----------------------------------");
		System.out.println(y); //y는 1 증가
		System.out.println(z); //z는 y가 증가되기 전 값이 저장		
		//변수의 값을 먼저 사용하고 나중에 증가
		
		//증감연산과 다른 연산자와 같이 사용(대입아닌 다른 연산자)
		x = 1; y = 1;
		
		z = ++x + 10; // x를 먼저 증가시키고 나머지 연산을 진행함
		int z1 = y++ + 10; //증감연산 제외한 나머지 연산을 진행하고 y를 증가시킴
		
		System.out.println("-----------------------------------");
		System.out.println(x); //
		System.out.println(z); //
		System.out.println(y); //
		System.out.println(z1);//
		
		//논리 부정 연산 : ! 
		
		boolean bl = true;
		
		System.out.println("-----------------------------------");
		System.out.println(!bl);	
		
		//비트 반전 연산자 : ~ 비트 데이터에 대해 0->1 1->0 반전
		//byte, short, int, long 타입만 피연산자가 될 수 있다
		System.out.println(~10); // 양수 10 00000000 00000000 00000000 00001010 -> 11111111 11111111 11111111 11110101

	}

}



