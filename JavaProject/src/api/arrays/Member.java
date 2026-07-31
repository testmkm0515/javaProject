package api.arrays;

//Comparable 인터페이스 구현
public class Member implements Comparable<Member>{
	String name;
	Member(String name){
		this.name = name;
	}
	
	//compareTo() 리턴값
	// - 오름차순일때 자신이 매개값보다 낮을 경우 음수, 같을 경우 0, 높으면 양수 반환
	@Override
	public int compareTo(Member o) {
		return name.compareTo(o.name);
	}
	
	
}
