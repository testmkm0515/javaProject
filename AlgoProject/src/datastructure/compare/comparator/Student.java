package datastructure.compare.comparator;

import java.util.Comparator;

public class Student implements Comparator<Student> {
	
	int age;
	int classNumber;//반번호로 대소 비교
	
	Student(int age, int classNumber){
		this.age = age;
		this.classNumber = classNumber;
	}
	
	@Override
	public int compare(Student o1, Student o2) { //기준 o1, 비교대상 o2
		return o1.classNumber - o2.classNumber;
	}
		
	public static void main(String[] args) {
		Student a = new Student(17,2);
		Student b = new Student(18,1);
		Student c = new Student(15,3);
		
		int isBig = a.compare(b, c); //a객체는 상관없이 b객체와 c객체를 비교
		
		if(isBig>0) {
			System.out.println("b객체가 c객체보다 큽니다");
		}else if(isBig == 0) {
			System.out.println("두 객체의 크기가 같습니다");
		}else {
			System.out.println("b객체가 c객체보다 작습니다");
		}		
	
	}

}
