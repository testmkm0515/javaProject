package sort;

import java.util.Arrays;

public class QuickSortMain {

	public static void main(String[] args) {
		int[] orig = {5,3,8,4,9,1,6,2,7};
		System.out.println("원본 배열 : " + Arrays.toString(orig) +"\n");
		QuickSort.sort(orig);
		System.out.println("\nQuick Sort 후 : " + Arrays.toString(orig));

	}

}
