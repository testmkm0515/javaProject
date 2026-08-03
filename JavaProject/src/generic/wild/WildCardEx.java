package generic.wild;

import java.util.Arrays;

public class WildCardEx {
	
	//수강생 제한 없는 일반과정
	public static void registerCourse(Course<?> course) { //Course 클래스의 제네릭 파라미터 타입에 제한 없음
		System.out.println(course.getName()+"수강생:"+
				Arrays.toString(course.getStudents()));
	}
	
	//학생 과정
	public static void registerCourseStudent(Course<? extends Student> course) { //Student클래스 기준 자신과 자식클래스만
		System.out.println(course.getName()+"수강생:"+
				Arrays.toString(course.getStudents()));		
	}
	
	//일반직장인과정
	public static void registerCourseWorker(Course<? super Worker> course) { //Worker클래스 기준 자신과 부모클래스만
		System.out.println(course.getName()+"수강생:"+
				Arrays.toString(course.getStudents()));		
	}	

	public static void main(String[] args) {
		// ? : 타입 제한 없음(관련된(동일패키지) 4개의 클래스만 사용)
		Course<Person> personCourse = new Course<Person>("일반인과정",5);
		personCourse.add(new Person("일반인"));
		personCourse.add(new Worker("직장인"));
		personCourse.add(new Student("학생"));
		personCourse.add(new HighStudent("고등학생"));
		
		
		Course<Worker> workerCourse = new Course<Worker>("직장인과정",5);
		workerCourse.add(new Worker("직장인"));
		
		Course<Student> studentCourse = new Course<Student>("학생과정",5);
		studentCourse.add(new Student("학생"));
		studentCourse.add(new HighStudent("고등학생"));
		
		Course<HighStudent> highStudentCourse = new Course<HighStudent>("고등학생과정",5);
		highStudentCourse.add(new HighStudent("고등학생"));
		
		// 모든 과정 등록 가능한 메서드
		registerCourse(personCourse);
		registerCourse(workerCourse);
		registerCourse(studentCourse);
		registerCourse(highStudentCourse);
		System.out.println();
		
		// 학생과정과 하위과정 가능한 메서드
		registerCourseStudent(personCourse);
		registerCourseStudent(workerCourse);
		registerCourseStudent(studentCourse);
		registerCourseStudent(highStudentCourse);
		System.out.println();
		
		// 직장인 과정과 상위과정 등록 가능한 메서드
		registerCourseWorker(personCourse);
		registerCourseWorker(workerCourse);
		registerCourseWorker(studentCourse);
		registerCourseWorker(highStudentCourse);
		System.out.println();		
	}

}







