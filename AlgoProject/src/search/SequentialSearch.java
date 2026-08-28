package search;

public class SequentialSearch {

	public static void main(String[] args) {
		int[] arr1 = {3,5,7,9,1};
		int[] arr2 = {1,3,5,7,9};
		
		System.out.println(sequentialSearch1(arr1, 2));
		System.out.println(sequentialSearch2(arr1, 5));
		
		}
	//정렬상관없는 데이터의 순차 탐색
	static int sequentialSearch1(int[] arr, int key) {
		int size = arr.length;
		
		for(int i=0; i<size; i++) {
			if(arr[i] == key) return i;
		}
		//못찾았을 경우
		return -1;
	}
	
	//정렬되어있는 데이터의 순차 탐색
	static int sequentialSearch2(int[] arr, int key) {
		int size = arr.length;
		
		for(int i=0; i<size; i++) {
			if(arr[i] == key) return i;
			//정렬된 배열 이므로 현재 값이 key보다 크면 break
			if(arr[i] > key) break;
		}
		//못찾았을 경우
		return -1;
	}	

}
