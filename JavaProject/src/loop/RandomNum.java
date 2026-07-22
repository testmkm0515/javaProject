package loop;

public class RandomNum {

	public static void main(String[] args) {
		// 난수 생성 : Math 클래스의 random() 메소드 사용
		// Math.random() : 0 < 난수 < 1 -> 실수형 난수 1개 반환
		for(int i=1; i<=10; i++) {
			int num = (int)(Math.random() * 10); //0~9
			System.out.println(num);
			num = (int)(Math.random() * 10)+1; //1~10
			System.out.println(num);			
		}

	}

}
