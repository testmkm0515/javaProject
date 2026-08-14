package datastructure.queue;

//Queue
//데이터 삽입시 앞이 비었음에도 오버플로우 발생
public class MyQueue {
	private int queueSize;
	private int front; //첫번째 요소 앞
	private int rear ; //마지막 요소
	private int num ; //현재 데이터 수
	private char[] queue; //큐 본체
	
	//생성자에서 초기화
	public MyQueue(int queueSize) {
		this.front = this.rear = -1;
		this.num = 0;
		this.queueSize = queueSize;
		queue = new char[queueSize];
	}
	//front와 rear의 값이 동일하면 데이터가 없는 상태
	public boolean isEmpty() {
		if(front == rear) {
			front = rear = -1;//큐가 비었으므로 모든 공간 사용 가능한 상태로 초기화
		}
		return front == rear;
	}
	
	//rear 포인터가 큐의 마지막 인덱스와 동일하면 full 상태
	public boolean isFull() {
		return (rear == queueSize-1);
	}
	
	//큐에 데이터 삽입
	public void enqueue(char item) {
		if(isFull()) { //마지막에 저장된 데이터가 큐의 마지막 원소로 저장되면 Full, front에서 삭제 후 비었어도 검증하지 않음
			System.out.println("enqueue 실패! Queue Full!");
		}else {
			queue[++rear] = item;
			num++;
		}
	}
	
	//큐에서 데이터 삭제
	public char dequeue() {
		if(isEmpty()) {
			System.out.println("큐 비었습니다");
			return 'E';
		}else {
			num--;
			front++; 
			return queue[front]; //queue의 front 포인터는 삭제할 데이터의 앞 index를 참조하고 있습니다
		}
			
	}
	
	//큐의 첫번째 데이터 추출(저장된지 가장 오래된 data)
	public char peek() {
		if(isEmpty()) {
			System.out.println("peek 실패 Empty!");
			return 'E';
		}else {
			return queue[front+1]; //front 포인터 변경되면 안됨
		}
	}
	
	//큐 초기화
	public void clear() {
		front = rear = -1;
		System.out.println("clear!");
	}
	
	//큐에 저장된 데이터 수 반환
	public int size() {
		return num;
	}
	
	//큐에 저장된 모든 데이터를 출력
	public void showQueue() {
		if(isEmpty()) {
			System.out.println("Queue Empty");
		}else {
			System.out.print("Queue items : ");
			for(int i=front+1;i<=rear;i++) {
				System.out.print(i + ":" + queue[i] + " ");
			}
			System.out.println();
		}
			
	}
	
	//전달된 data가 Queue에 저장된 데이터 인지 확인 후 해당 인덱스 반환
	public int contains(char value) {
		if(isEmpty()) {
			System.out.println("Queue Empty!");
		}else {
			for(int i=front+1; i<=rear; i++) {
				if(queue[i]==value) {
					return i;
				}
			}
			
		}
		return -1; //해당 value가 queue에 없음
	}

}








