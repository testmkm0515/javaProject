package loop;

import java.util.Random;
public class RandomNum2 {

	public static void main(String[] args) {
		// Random 클래스 활용 난수 발생
		Random rd = new Random();
		
		for(int i=1; i<=10; i++) {
			int num = rd.nextInt(10); //0~9
			num = rd.nextInt(10)+1; //1~10
			System.out.println(num);
		}

	}

}
