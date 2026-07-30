package anonymousex.local;

public class Anonymous {
	private int field;
	
	public void method(final int arg1, int arg2) {//final이 없지만 메소드내에서 수정되지 않음, 로컬익명객체 메서드에서 사용가능
		//로컬변수
		final int var1 = 0;
		int var2 = 0;
		//멤버필드 수정 : 멤버필드는 로컬클래스나 로컬익명객체에서 사용가능하고 값이 수정되어도 상관 없음
		field = 10;
		//메소드 처리 연산에서 로컬 변수를 수정한다면
		var2 = 20; //var2는 일반로컬변수임, final의 성질이 없어짐, 이런경우 로컬익명객체 메소드에서 사용불가능
		//익명객체 참조하는 변수
		ICalculatable calc = new ICalculatable() {
			//익명객체 내에서 로컬변수/매개변수 사용예시
			@Override
			public int sum() {
				//익명객체가 클래스 멤버 메소드 내부에 있음(로컬익명객체)
				//로컬/매개변수 사용할 수 있지만 해당 변수들이 final 이어야 함
				//final이 붙어있지 않은 로컬변수여도 메소드내에서 초기화 이후 수정되지 않았다면 
				//컴파일러가 final을 붙여줌
				int result = field + arg1 + arg2 + var1 + var2; //수정하지 않는 로컬변수/매개변수만 사용
				return result;
			}
		};
		System.out.println(calc.sum());
	}
}
