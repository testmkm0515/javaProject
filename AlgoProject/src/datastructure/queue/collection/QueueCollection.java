package datastructure.queue.collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueCollection {

	public static void main(String[] args) {
		// 자바 : Queue 인터페이스 제공 구현은 LinkedList
		// enqueue -> add(), dequeue -> poll()
		
		Queue<String> q = new LinkedList<String>();
		
		//값 추가 : add, offer
		System.out.println("큐에 4개 값 삽입");
		q.add("홍길동");
		q.add("이몽룡");
		q.add("성춘향");
		
		q.offer("김철수");
		
		//Queue toString 재정의 되어 있음
		System.out.println("\n 큐 내용 출력");
		System.out.println(q);

		System.out.println("\n큐의 크기(저장된 원소 수) : " + q.size());
		System.out.println("\n첫번째 값 : " + q.peek());
		
		//큐의 원소값 삭제 : poll, remove():front+1의 원소값 삭제/remove(삭제할값):삭제할 값이 있으면 삭제 후 true를 리턴
		System.out.println("\n큐의 삭제 : " + q.poll());
		System.out.println(q);
		System.out.println("\n큐의 삭제 : " + q.remove());
		System.out.println(q);	
		
		System.out.println("\n큐의 삭제(검색해서 삭제) : " + q.remove("김철수")); //true 반환
		System.out.println(q);	
		
		System.out.println("\n큐의 삭제(검색값이 없을경우) : " + q.remove("김철수")); //false 반환
		System.out.println(q);
		
		
		
		
	}

}
