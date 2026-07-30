package api.objectapi.finalize;

//모든 클래스 Object 클래스 상속받음
public class Counter {
	private int no;
	
	public Counter(int no) {
		this.no = no;
	}

	//GC에 의해 객체가 소멸될때 JVM에 의해 호출 : 예외처리 필요
	@Override
	protected void finalize() throws Throwable {		
		 System.out.println(no+"번 객체의 finalize()가 실행됨");
	}
	
	
}
