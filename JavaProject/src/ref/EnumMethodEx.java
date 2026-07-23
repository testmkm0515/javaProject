package ref;

public class EnumMethodEx {

	public static void main(String[] args) {
		// 열거객체 메소드 확인
		Week today = Week.SUNDAY;
		String name = today.name(); //열거객체가 저장하고 있는 문자열 리턴
		System.out.println(name);
		
		int ord = today.ordinal(); // 열거 객체의 순번 리턴
		System.out.println(ord);
		
		//compareTo() : 매개값과 비교
		//반환값 음수 : 순번이 빠른 경우, 양수 : 순번이 늦은 경우
		
		Week day1 = Week.MONDAY;
		Week day2 = Week.WEDNESDAY;
		
		System.out.println(day1.compareTo(day2)); // -2 : day1이 day2보다 순번이 빠름
		System.out.println(day2.compareTo(day1)); // 2 : day2는 day1보다 순번이 늦다
		
		Week weekDay = Week.valueOf("SUNDAY"); //매개값과 동일한 문자열을 가지는 열거객체를 리턴
		weekDay = Week.valueOf("SUNDAY1"); //매개값과 동일한 문자열을 가지는 열거객체가 없으면 오류 발생
		System.out.println(weekDay);
	}

}
