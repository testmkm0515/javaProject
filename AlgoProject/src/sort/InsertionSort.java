package sort;

public class InsertionSort {

	public static void main(String[] args) {
		// 삽입정렬
		int[] arr = {5,2,8,3,1};
		
		insertionSort(arr);
	}
	
	static void insertionSort(int[] arr) {
		int temp, index;
		
		System.out.println("초기배열 : ");
		for(int i=0; i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println("\n정렬진행 : ");
		
		//초기 k값 : 두번째 원소(idx 1)
		for(int i=1; i<arr.length; i++) {
			System.out.println();
			//타겟(k) 넘버
			System.out.println("k 값 : " + arr[i]);
			temp = arr[i];//정렬되지 않은 원소 중 가장 왼쪽위치에 있는 원소(k) 저장
			index=i-1; //index ~ 0번 원소까지 비교하다가 temp보다 큰 원소가 나타나면 이동 , 교환
			
			//k값이 들어갈 위치를 찾고 이동해서 자리 비우기
			while(index >= 0 && temp < arr[index]) {
				System.out.print(arr[index] + "이동" + "\n");;
				arr[index+1] = arr[index];
				index--;
			}
			/*
			 * 반복문이 종료되면 앞의 원소가k값 보다 작다는 의미
			 * k원소는 index 원소보다 오른쪽에 와야 하므로
			 * index + 1에 위치
			 */
			arr[index + 1] = temp;

			for(int k=0; k<arr.length;k++) {
				System.out.print(arr[k] + " ");
			}
			System.out.println();			
		}
		
		System.out.println();
		System.out.println("정렬된 배열 : ");
		for(int i=0; i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
	}

}





