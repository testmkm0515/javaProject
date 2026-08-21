package sort;

public class ShellMain {

	public static void main(String[] args) {
		int[] arr = {10,8,6,20,4,3,22,1,0,15,16};
		
		System.out.println("초기 배열");
		for(int k=0; k<arr.length; k++) {
			System.out.print(arr[k] + " ");			
		}
		System.out.println();
		
		ShellSort.shellSort(arr);
		
		System.out.println();
		
		System.out.println("\n정렬 결과 ");
		for(int k=0; k<arr.length; k++) {
			System.out.print(arr[k] + " ");			
		}
		System.out.println();		
		
	}

}
