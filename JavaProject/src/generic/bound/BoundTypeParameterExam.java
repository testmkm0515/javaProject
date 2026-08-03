package generic.bound;

public class BoundTypeParameterExam {

	public static void main(String[] args) {
		// 제네릭 파라미터 타입 제한
		//Util.compare("a", "b");
		
		System.out.println(Util.compare(10,20));
		System.out.println(Util.compare(4.3,3));
		//System.out.println(Util.compare('a','a')); //char은 Number 클래스의 자식 클래스가 아님

	}

}
