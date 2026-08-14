package datastructure.queue;

import java.util.Scanner;

public class CircularQueue {
	private int queueSize;
	private int front;
	private int rear;
	private int[] queueArr;
	Scanner sc;
	private int item;
	
	//생성자 초기화(큐 크기 설정, 원형큐는 공백/포화 상태를 표현하기 위해 1칸을 비워두므로 실제 저장공간은 -1 공간
	public CircularQueue(int queueSize) {
		this.queueSize = queueSize;
		front = 0 ; //배열 1칸 비우기
		rear = 0 ;
		queueArr = new int[queueSize];
		sc = new Scanner(System.in);
	}
	//큐가 비어있는지
	public boolean isEmpty() {
		return front==rear;
	}
	
	//큐가 가득 차 있는지
	public boolean isFull() {
		return (rear+1) % queueSize == front;
	}
	//데이터저장
	public boolean enqueue() {
		if(isFull()) {
			System.out.println("Queue is Full");
			return false;
		}
		System.out.println("enqueue data : ");
		int item = sc.nextInt();
		
		rear = (rear + 1) % queueSize; //rear를 이동
		queueArr[rear] = item;
		System.out.println("Front : "+front+" Rear : "+rear);
		return true;
	}
	
	//데이터삭제
	public boolean dequeue() {
		if(isEmpty()) {
			System.out.println("Queue Empty!");
			return false;
		}
		front = (front + 1) % queueSize;
		item = queueArr[front];
		queueArr[front] = 0;
		System.out.println("Front : "+front+" Rear : "+rear);
		return true;		
	}
	
	//삭제될수 있는 data 값을 반환(가장 앞에 있는, 가장 먼저 저장된)
	public int peek() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}
		return queueArr[(front+1) % queueSize];
	}
	
	public void print() {
	END:while(true) {
			System.out.println("==========원형 큐==========");
			System.out.println("1.enque / 2. deque / 3. exit");
			System.out.print("선택 : ");
			int num = sc.nextInt();
			
			switch(num) {
				case 1 : 
					boolean check = enqueue();
					for(int i=0; i<queueArr.length;i++) {
						System.out.print(queueArr[i] + " ");
					}
					if(check) {
						System.out.println("enqueue 성공!");
					}
					break;
				case 2 : 
					boolean chk = false;
					chk = dequeue();
					for(int i=0; i<queueArr.length;i++) {
						System.out.print(queueArr[i] + " ");
					}					
					if(chk==true) {
						System.out.println("Dequeue 성공 item : " + this.item);
					}
					break;
				case 3 : 
					System.out.println("종료");
					System.out.println("큐 현황");
					for(int i=0; i<queueArr.length;i++) {
						System.out.print(queueArr[i] + " ");
					}					
					break END;					
			}
		}
	}
	
	
}







