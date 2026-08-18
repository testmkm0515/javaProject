package datastructure.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class CollectionEx {
	static void printList(ArrayList<String> list) {
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			String element = iterator.next();
			String separator;
			if(iterator.hasNext())
				separator="->";
			else
				separator="\n";
			System.out.print(element + separator);
		}
	}
	
	public static void main(String[] args) {
		// Collection 클래스의 static 메서드 확인
		ArrayList<String> myList = new ArrayList<String>();
		myList.add("트랜스포머");
		myList.add("스타워즈");
		myList.add("매트릭스");
		myList.add("터미네이터");
		myList.add("아바타");
		
		System.out.print("리스트 순서 : ");
		for(String movie:myList) {
			System.out.print(movie + " | ");
		}
		
		System.out.print("\n오름차순 정렬 : ");
		Collections.sort(myList); //원본변경
		printList(myList);
		
		//전달된 data의 index 반환
		int index = Collections.binarySearch(myList,"스타워즈");
		System.out.println("스타워즈"+"는(은)"+(index+1)+"번째 입니다.");
		
		System.out.print("\n내림차순 정렬 : ");
		Collections.reverse(myList); //원본변경
		printList(myList);		
		

	}

}
