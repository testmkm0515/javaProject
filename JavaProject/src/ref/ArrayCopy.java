package ref;

import java.util.Arrays;

public class ArrayCopy {

	public static void main(String[] args) {
		// 배열의 복사
		// (1) 얕은 복사 : 객체를 새로 생성하는것이 아니라 객체의 주소만 복사
		// 변수의 이름만 다르고 같은 객체(배열)를 참조하게 됨
		// a참조해서 수정하면 b를 통해 접근시 수정 결과 확인됨
		int a[] = {1,2,3,4};
		int b[] = a; //a 참조변수에 저장된 참조 주소값이 b 변수에 저장됨
		
		//변경전 출력 - a,b 변수 출력값이 동일
		for(int i=0; i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
		for(int i=0; i<b.length;i++) {
			System.out.print(b[i]+" ");
		}	
		System.out.println();
		//a 변수 변경 진행
		a[0] = 10;
		
		//변경후 출력
		for(int i=0; i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
		for(int i=0; i<b.length;i++) {
			System.out.print(b[i]+" ");
		}
		
		// 두 배열변수가 동일한 배열 객체를 참조
		
		// (2) 깊은복사
		// 1. 배열객체를 새로 생성해서 원본의 원소를 하나씩 저장
		// Object.clone()
		// Arrays.copyOf()
		// Arrays.copyOfRange()
		// System.arraycopy()

		// 1. 
		int[] a1 = {1,2,3,4};
		int[] b1 = new int[a1.length];
		
		// 각 원소값을 하나씩 저장
		for(int i=0; i<a1.length;i++) {
			b1[i] = a1[i];
		}
		
		System.out.println();
		//변경전 출력 - a1,b1 변수 출력값이 동일
		for(int i=0; i<a1.length;i++) {
			System.out.print(a1[i]+" ");
		}
		System.out.println();
		for(int i=0; i<b1.length;i++) {
			System.out.print(b1[i]+" ");
		}	
		System.out.println();
		//a 변수 변경 진행
		a1[0] = 10;
		
		//변경후 출력
		for(int i=0; i<a1.length;i++) {
			System.out.print(a1[i]+" ");
		}
		System.out.println();
		for(int i=0; i<b1.length;i++) {
			System.out.print(b1[i]+" ");
		}		
		
		//2. Object.clone() -> Object를 모든 클래스는 상속받기때문에 배열객체에도 Object의 clone() 메소드가 있음
		int[] a2 = {1,2,3,4};
		int[] b2 = a2.clone();

		System.out.println("Object.clone()이용한 깊은복사");
		//변경전 출력 - a1,b1 변수 출력값이 동일
		for(int i=0; i<a2.length;i++) {
			System.out.print(a2[i]+" ");
		}
		System.out.println();
		for(int i=0; i<b2.length;i++) {
			System.out.print(b2[i]+" ");
		}	
		System.out.println();
		//a2 변수 변경 진행
		a2[0] = 10;
		
		//변경후 출력
		for(int i=0; i<a2.length;i++) {
			System.out.print(a2[i]+" ");
		}
		System.out.println();
		for(int i=0; i<b2.length;i++) {
			System.out.print(b2[i]+" ");
		}
		
		//3. Arrays
		// Arrays.copyOf(원본배열, 복사할길이) - 새로운 배열객체 생성 후 반환
		// Arrays.copyOfRange(원본배열, 시작인덱스, 끝인덱스+1) - 새로운 배열객체 생성 후 반환
		int[] a3 = {1,2,3,4};
		int[] b3 = Arrays.copyOf(a3, a3.length);
		int[] b3One = Arrays.copyOfRange(a3, 1, 3); //인덱스 1~2
		
		System.out.println();
		System.out.println("Arrays.copyOf()이용한 깊은복사");
		//변경전 출력 - a1,b1 변수 출력값이 동일
		for(int i=0; i<a3.length;i++) {
			System.out.print(a3[i]+" ");
		}
		System.out.println();
		for(int i=0; i<b3.length;i++) {
			System.out.print(b3[i]+" ");
		}	
		System.out.println();
		//a2 변수 변경 진행
		a3[0] = 10;
		
		//변경후 출력
		for(int i=0; i<a3.length;i++) {
			System.out.print(a3[i]+" ");
		}
		System.out.println();
		for(int i=0; i<b3.length;i++) {
			System.out.print(b3[i]+" ");
		}	
		
		System.out.println();
		System.out.println("Arrays.copyOfRange()이용한 깊은복사");
		
		for(int i=0; i<b3One.length;i++) {
			System.out.print(b3One[i]+" ");
		}	
		
		// 배열 크기 변경 불가능 - 더 큰 배열 필요시 새 배열 생성 후 기존 배열 원소 값 복사
		int[] a5 = {1,2,3,4};
		int[] b5 = new int[10];
		
		// 각 원소값을 하나씩 저장
		for(int i=0; i<a5.length;i++) {
			b5[i] = a5[i];
		}	
		System.out.println();
		for(int i=0; i<b5.length;i++) {
			System.out.print(b5[i]+" ");
		}
		
		// 향상된 for문 : 참조 객체 중 배열 또는 컬렉션의 항목요소를 순처적으로 처리
		// index 이용하지 않고 바로 항목 요소 반복 가능
		// for(반복변수 : 배열 또는 컬렉션){반복문장}
		// 배열의 모든 원소 순회 사용할 경우 사용
		int sum=0;
		int[] scores= {95,71,84,93,87};
		
		for(int score : scores) {
			sum += score;
		}
		
		System.out.println();
		System.out.println("sum의 값 : " + sum);
		
		String[] flowers = {"해바라기", "장미","진달래"};
		for(String flower : flowers) {
			System.out.print(flower + " ");
		}

	}

}
