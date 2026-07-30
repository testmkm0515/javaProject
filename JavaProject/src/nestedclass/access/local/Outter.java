package nestedclass.access.local;

//로컬 클래스에서 사용 제한
//메소드의 매개변수와 로컬변수가 final인 경우
public class Outter {
	public void method2(final int arg1) { //매개변수
		final int localVariable1 = 1; //로컬변수
		//변경불가
		//arg1 = 100; 
		//localVariable1 = 100;
		
		class Inner{ //로컬 클래스
			public void method() {
				//처리 진행 시 매개변수나 로컬변수 사용시 final 인것만 사용하자
				int result = arg1 + localVariable1; 
			}
		}
	}
}
