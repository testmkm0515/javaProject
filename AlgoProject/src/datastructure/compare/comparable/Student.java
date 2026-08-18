package datastructure.compare.comparable;

//Comparable -> 객체1.compareTo(객체2)
public class Student implements Comparable<Student>{
	//age값으로 대소 비교
	int age;
	int classNumber;//학급 번호
	
	Student(int age, int classNumber){
		this.age = age;
		this.classNumber = classNumber;
	}
	
	@Override
	public int compareTo(Student o) {
		return this.age - o.age;
	}
}
