package datastructure.queue;

public class MyQueueMoveMain {

	public static void main(String[] args) {
		// 구현한 Queue 사용
		int queueSize = 3;
		MyQueueMove q = new MyQueueMove(queueSize);
		
		q.showQueue();
		System.out.println("데이터 수 : " + q.size());
		
		System.out.println("\na,b,c 삽입 수행");
		q.enqueue('a');
		q.enqueue('b');
		q.enqueue('c');
		q.showQueue();
		System.out.println("데이터 수 : " + q.size());
		
		System.out.println("\n첫번째 값 확인(peek 수행) : " + q.peek());
		
		System.out.println("\ndeque 수행");
		System.out.println("\n반환(삭제)된 값 : " + q.dequeue());
		System.out.println("\n반환(삭제)된 값 : " + q.dequeue());		
		q.showQueue();
		System.out.println("데이터 수 : " + q.size());		

		System.out.println("\nd enqueue 수행");
		q.enqueue('d');
		q.showQueue();
		/*
		System.out.println("\n첫번째 값 확인(peek 수행) : " + q.peek());
		
		System.out.println("\nd, e 삽입 수행");
		q.enqueue('d');
		q.enqueue('e');		
		q.showQueue();
		System.out.println("데이터 수 : " + q.size());		

		System.out.println("\nd, f 삽입 수행");
		q.enqueue('f');	 //데이터가 4개이고 0 위치가 비었음에도 FULL 출력
		//-> rear와 queueSize-1이 동일하면 오버플로우가 발생
		//-> 해결 : 이동큐, 원형큐
		System.out.println("\nclear 수행");
		q.clear();
		q.showQueue();
		
		System.out.println("\nx enqueue 수행");
		q.enqueue('x');
		q.showQueue();
		*/
	}

}
