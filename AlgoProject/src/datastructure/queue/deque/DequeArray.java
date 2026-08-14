package datastructure.queue.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

// java.util.Deque 인터페이스를 ArrayDeque로 구현
// 배열기준이기 때문에 용량초과 overflow 발생 가능
public class DequeArray {
	public static void main(String[] args) {
		//Deque<String> dq = new ArrayDeque<>();
		Deque<String> dq = new LinkedList<>(); //LinkedList도 Deque 인터페이스 구현 객체
		System.out.println("데이터 3개 삽입"); //add, offer
		dq.add("포도");
		dq.add("배");
		dq.add("수박");
		dq.offer("사과");
		System.out.println(dq);
		
		//Deque addFirst() : 앞쪽에서 삽입
		System.out.println("\n앞쪽에 삽입"); //addFirst
		dq.addFirst("바나나");
		System.out.println(dq);
		dq.add("복숭아");
		System.out.println(dq);
		System.out.println("\n뒤쪽에 삽입");//addLast, add와 동일
		dq.addLast("복숭아");
		System.out.println(dq);
		
		System.out.println("\npeek : " + dq.peek()); //위치적으로 가장 앞에있는 값 반환
		System.out.println("\nsize : " + dq.size());
		
		//데크 순회 : 배열 순회와 같음
		System.out.println("\n데크 순회");
		for(String item : dq) {
			System.out.print(item + " ");
		}
		//remove() : 맨 앞 데이터 삭제
		System.out.println("\n\n 데이터 꺼내기 ");
		System.out.println("\nremove : " + dq.remove());
		System.out.println(dq);
		System.out.println("\nremove : " + dq.remove());
		System.out.println(dq);	
		
		//remove(값) : 해당값이 deque에 있으면 true반환하고 해당값의 원소를 삭제
		System.out.println("\nremove : " + dq.remove("사과"));
		System.out.println(dq);
		//remove(값) : 해당값이 deque에 없으면 false 반환
		System.out.println("\nremove : " + dq.remove("사과"));
		System.out.println(dq);
		//remove(값) : 해당값이 deque에 있고 동일 값이 여러개 있는 경우 첫번째 값을 삭제
		System.out.println("\nremove : " + dq.remove("복숭아"));
		System.out.println(dq);
		//removeAll(삭제객체) : 모든 원소 삭제
		System.out.println("\nremove : " + dq.removeAll(dq));
		System.out.println(dq);
		
		/////////////////////////////////
		System.out.println("데이터 3개 삽입"); 
		System.out.println(dq.add("포도")); //add 성공하면 true반환 용량 초과시 Exception
		dq.add("배");
		dq.add("수박");
		System.out.println(dq.offer("사과"));
		
		//삭제 메소드 : poll
		System.out.println(dq);	
		System.out.println("poll : " + dq.poll());
		System.out.println(dq);
		System.out.println("pollFirst : " + dq.pollFirst());//첫 데이터 삭제
		System.out.println(dq);	
		System.out.println("pollLast: " + dq.pollLast());//마지막 데이터 삭제
		System.out.println(dq);	
		
		//addFirst, pollFirst : front의 삽입과 삭제
		//addLast, pollLast : rear의 삽입과 삭제
		
		//데크를 스택처럼 사용가능 : pop/push
		System.out.println("push 수행");
		dq.push("밤");
		dq.push("밤");
		System.out.println(dq);
		dq.pop();
		System.out.println(dq);
	}

}
