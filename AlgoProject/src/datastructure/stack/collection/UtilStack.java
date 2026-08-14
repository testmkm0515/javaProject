package datastructure.stack.collection;

import java.util.Stack;

public class UtilStack {

	public static void main(String[] args) {
		// 자바 collection이 제공하는 Stack 클래스
		Stack<String> stack = new Stack<>();
		try {
			stack.push("홍길동");
			stack.push("이몽룡");
			stack.push("성춘향");
			
			//utility 제공 Stack은 ArrayList 타입
			//get 메서드 사용가능
			for(int i=0; i<stack.size(); i++) {
				System.out.println(i + ":" + stack.get(i));
			}
			
			System.out.println("스택 data 수 : " + stack.size());
			System.out.println("최상위 값 : " + stack.peek());
			System.out.println("이몽룡이 들어있나? : " + stack.contains("이몽룡"));
			System.out.println("pop : " + stack.pop());
			System.out.println("pop : " + stack.pop());
			stack.clear();
			System.out.println("clear : 수행");
			System.out.println("empty? : " + stack.empty());
			
			//java class Stack pop -> underflow처리 되어 있지 않음
			System.out.println(stack.pop());}
		catch(Exception e) {
			System.out.println(e.toString());
		}
		
	}

}
