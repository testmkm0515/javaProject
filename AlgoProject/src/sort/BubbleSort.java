package sort;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {5,3,8,1,2,7};
		bubbleSort(arr);

	}
	
	static void bubbleSort(int[] arr) {
		int temp;
		
		for(int i=0; i<arr.length ; i++) {
			for(int j=0; j<arr.length-1-i; j++) {//라운드 순회마다 가장 큰 원소가 하나씩 결정됨, 비교가 줄어듬 i변수가 비교횟수를 결정함
				if(arr[j] > arr[j+1]) { //인접원소 비교후 앞 원소가 크면 뒤 원소와 교환
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			for(int k=0; k<arr.length; k++) {
				System.out.print(arr[k] + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.print("정렬 결과 : ");
		for(int k=0; k<arr.length; k++) {
			System.out.print(arr[k] + " ");
		}
		System.out.println();	
	}

}
