package sort;

import java.util.Arrays;

public class MergeSortMain {

	public static void main(String[] args) {
		int[] orig = {8,2,6,4,7,3,9,5};
		System.out.println("원본 배열 : " + Arrays.toString(orig));
		MergeSort.mergeSort(orig);
		System.out.println("Merge Sort : " + Arrays.toString(orig));

	}

}
