package datastructure.stack.generic;

import java.util.EmptyStackException;

//generic 타입의 클래스로 구성하고 객체 생성 시 타입 결정
public class StackGeneric <E>{
	private int stackSize; //스택 크기
	private int top; //스택 포인터
	private Object[] stackArr; //스택 -> 모든타입 처리 가능하도록 Object 타입으로 구현->Generic으로 형변환
	
	//생성자 : 스택 초기화
	//배열 index는 0부터 시작하므로 top은 -1로 초기값 설정	
	public StackGeneric(int stackSize) {
		this.stackSize = stackSize;
		this.top = -1;
		this.stackArr = new Object[stackSize];
	}	
	
	// stack 기능 구현

	//스택이 비어있는가? underflow
	public boolean isEmpty() {
		return top == -1 ;
	}
	
	//스택이 가득 찼는가? overflow
	public boolean isFull() {
		return top == stackSize-1; //전체 배열 원소수 -1이 마지막 index 값
	}

	//push되는 데이터 타입 generic
	public void push(E item) {
		if(isFull()) {
			System.out.println("Stack Full. Overflow");
		}else {
			//Object type 배열에 저장 -> generic 타입이므로 나중에 item의 타입은 결정됨
			//Object는 최상위 클래스이므로 어떤 타입도 저장 가능
			stackArr[++top] = item;
		}
	}
	
	public E pop() {
		if(isEmpty()) {
			System.out.println("Stack Empty");
			//제네릭 타입을 반환 해야 하는 경우에 예외상황이면 예외를 던지는 방법을 많이 사용함
			throw new EmptyStackException();
		}else {
			//Object 타입을 E 타입으로 형변환 (E)
			@SuppressWarnings("unchecked")
			E item = (E) stackArr[top--];
			return item ;
		}		
	}
	
	public E peek() {
		if(isEmpty()) {
			System.out.println("Stack Empty");
			throw new EmptyStackException();
		}else {
			@SuppressWarnings("unchecked")
			E item = (E)stackArr[top];
			return item;
		}		
	}
	
	public void showStack() {
		if(isEmpty()) {
			System.out.println("Stack Empty");
		}else {
			System.out.print("Stack items : ");
			for(int i=0;i<=top;i++) {
				System.out.print(i + ":" + stackArr[i] + " ");
			}
			System.out.println("\ntop : " + top);
		}
	}
	

	public int size() {
		//stack의 data수 return
		return top+1;
	}
	
	public int getCapacity() {
		//Stack 용량 return
		return stackSize;
	}
	
	
	
	
	
	
	
	
	
	
	
}
