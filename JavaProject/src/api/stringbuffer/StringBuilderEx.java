package api.stringbuffer;

public class StringBuilderEx {

	public static void main(String[] args) {
		// StringBuffer/StringBuilder클래스 : 
		// buffer(데이터를 임시로 저장하는 메모리)에 문자열을 저장 후 처리하는 메서드를 제공하는 클래스
		// 멀티스레드 : StringBuffer 클래스
		// 단일스레드 : StringBuilder 클래스
		
		// 현재 프로그램 단일 스레드 프로그램 : StringBuilder 클래스
		
		StringBuilder sb = new StringBuilder();
		//Builder 객체 문자열을 char [] 처리
		//메소드를 통해 buffer 처리
		//append() : 버퍼에 문자열 추가
		sb.append("JAVA ");
		sb.append("Program Study");
		System.out.println(sb.toString());
		
		//insert(offeset, "삽입할 문자열"), offset에 문자를 삽입 뒤 문자들은 하나씩 밀려남
		sb.insert(4, "2");
		System.out.println(sb.toString());
		
		//setCharAt(idnex, 바꿀문자) : 특정 위치의 문자 변경
		sb.setCharAt(4, '6');
		System.out.println(sb.toString());
		
		//replace(start,end, 대치문자열) : start부터 end-1까지의 문자를 대치문자열로 변환
		sb.replace(6, 13, "Book");
		System.out.println(sb.toString());
		
		//delete(start, end) : start부터 end-1까지의 문자를 삭제
		sb.delete(4, 5); //4부터 5-1까지 삭제
		System.out.println(sb.toString());
		
		int length = sb.length();
		System.out.println("총 문자수 : "+length);
		
		//String Builder는 toString() 메서드 재정의 되어 있음
		System.out.println(sb);
		
		

	}

}
