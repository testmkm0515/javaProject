package sort;

public class SelectionSort {

	public static void main(String[] args) {
		// 선택정렬
		int[] arr = {5,2,8,3,1};
		selectionSort(arr);
	}
	
	static void selectionSort(int[] arr) {
		int temp; //교환할때 사용
		
		System.out.println("초기배열 : ");
		for(int i=0; i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println("\n정렬진행 : ");
		//총 라운드 배열 크기 - 1
		for(int i=0; i<arr.length-1; i++) {
			for(int j= i+1; j<arr.length;j++) {
				if(arr[i] > arr[j]) { //i는 값이 결정되지 않은 원소들 중 맨 앞을 키(i)로 잡아 교환
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
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












