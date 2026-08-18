package datastructure.compare.comparable;

public class StudentMain {

	public static void main(String[] args) {
		Student st1 = new Student(19, 2);
		Student st2 = new Student(17, 2);
		
		int isBig = st1.compareTo(st2);
		
		if(isBig>0) {
			System.out.println("st1객체가 st2객체보다 큽니다");
		}else if(isBig == 0) {
			System.out.println("두 객체의 크기가 같습니다");
		}else {
			System.out.println("st1객체가 st2객체보다 작습니다");
		}

	}

}
