package search;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = {1,3,4,12,15,34,36,42,51,64,66,70,88,89,94,100}; //2진탐색은 정렬된 데이터에 대하여 적용
		
		System.out.println("89의 위치 : " + search(arr, 89));
		System.out.println("3의 위치 : " + search(arr, 3));
	}
	
	private static int search(int[] arr, int target) {
		int start = 0 ; //시작 idx
		int end = arr.length-1; //끝 idx
		int mid; //key 위치
		
		while(start<=end) {
			mid = (start + end) / 2;
			
			if(arr[mid]<target) {
				start = mid + 1;
			}else if (arr[mid] > target) {
				end = mid-1;
			}else {
				return mid;
			}
		}
		return -1;
		
	}

}
