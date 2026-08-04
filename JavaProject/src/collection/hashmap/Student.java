package collection.hashmap;

//entery의 key로 사용할 객체
public class Student {
	private String stdNo;
	private String stdName;
	
	public Student(String stdNo, String stdName) {
		this.stdNo = stdNo;
		this.stdName = stdName;
	}

	public String getStdNo() {
		return stdNo;
	}

	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	//동등객체인지 판단하기 위한 메서드 재정의
	
	@Override
	public int hashCode() {
		return stdNo.hashCode() + stdName.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		//Student 객체인지 확인
		if(obj instanceof Student) {
			//obj의 필드와 현재 객체의 필드 값이 모두 동일한지 확인
			Student student = (Student)obj;
			return (stdNo.equals(student.stdNo)) && (stdName.equals(student.stdName));
		}else {
			return false;
		}
	}
	
	
}










