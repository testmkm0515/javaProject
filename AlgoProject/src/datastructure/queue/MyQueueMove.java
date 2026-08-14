package datastructure.queue;

//Queue
//오버플로우 발생 시 dequeue된 공간이 있는 경우 이동해서 해결
public class MyQueueMove {
	private int queueSize;
	private int front; //첫번째 요소 앞
	private int rear ; //마지막 요소
	private int num ; //현재 데이터 수
	private char[] queue; //큐 본체
	
	//생성자에서 초기화
	public MyQueueMove(int queueSize) {
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
	
	//rear 포인터가 큐의 마지막 인덱스와 동일하고 데이터 수가 queueSize와 동일하면 Full
	public boolean isFull() {
		return (rear == queueSize-1 && num == queueSize);
	}
	
	//큐에 데이터 삽입
	public void enqueue(char item) {
		if(isFull()) { //마지막에 저장된 데이터가 큐의 마지막 원소로 저장되면 Full, front에서 삭제 후 비었어도 검증하지 않음
			System.out.println("enqueue 실패! Queue Full!");
		}else if(rear == queueSize-1 && num != 0) {//이동이 필요한 경우
			//배열 copy로 이동을 구현 -> System.arrayCopy(소스, 소스의시작인덱스,대상, 대상의 시작 인덱스, copy할 원소수)
			//a배열에서 a배열로 copy 가능 - 새로운 배열 인스턴스 생성해서 기존 참조변수에 대입
			System.arraycopy(queue, front+1, queue, 0, num);
			System.out.println("큐 이동 발생");
			front = -1; //이동한 큐는 0번 인덱스부터 값을 채웠음
			rear = num-1; //이동한 큐의 원소는 기존 배열의 데이터 수이므로 데이터수 -1 인덱스
			queue[++rear]=item;
			num++;
		}
		else {//rear != queueSize-1 -> rear포인터 뒤에 공간이 있음
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








