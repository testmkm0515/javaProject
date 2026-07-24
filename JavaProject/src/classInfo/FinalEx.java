package classInfo;

public class FinalEx {

	public static void main(String[] args) {
		// final 필드 사용
		Final f1 = new Final("123456789-56789","계백");
		
		System.out.println(f1.nation);
		System.out.println(f1.ssn);
		System.out.println(f1.name);
		
		f1.nation="japan"; //final 필드 : 수정 불가능
		f1.ssn="5555-6666";//수정 불가능
		f1.name="을지문덕";
		

	}

}
