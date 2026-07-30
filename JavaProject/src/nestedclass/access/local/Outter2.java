package nestedclass.access.local;

public class Outter2 {
	public void method2(final int arg1, int arg2) { //매개변수
		final int localVariable1 = 1; //로컬변수
		arg2 = 200; //변경되면 final이 아니라고 해석
		
		class Inner{ //로컬 클래스
			public void method() {
				//처리 진행 시 매개변수나 로컬변수 사용시 final 인것만 사용하자
				int result = arg1 + localVariable1 + arg2; //final이 아니므로 사용 불가능
			}
		}
	}
}
