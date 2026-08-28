package datastructure;

import java.util.Arrays;

public class HeapMain {

	public static void main(String[] args) {
		Heap<Integer> heap = new Heap<>();
		
		heap.add(10);
		heap.add(3);
		heap.add(23);
		heap.add(44);
		heap.add(19);
		heap.add(35);
		heap.add(47);
		heap.add(80);
		heap.add(35);
		heap.add(60);
		
		System.out.println(heap.peek());
		System.out.println(Arrays.toString(heap.toArray()));
		
		System.out.print(heap.remove() + " " + heap.remove() + " "+ heap.remove() + " ");
		System.out.print(heap.remove() + " " + heap.remove() + " "+ heap.remove() + " ");
		System.out.print(heap.remove() + " " + heap.remove() + " "+ heap.remove() + " " + heap.remove());

	}

}
