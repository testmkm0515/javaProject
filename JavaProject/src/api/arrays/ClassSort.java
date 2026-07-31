package api.arrays;

import java.util.Arrays;

public class ClassSort {

	public static void main(String[] args) {
		//Arrays.sort()
		Member m1 = new Member("홍길동");
		Member m2 = new Member("박동수");
		Member m3 = new Member("김민수");
		Member[] members = {m1,m2,m3};
		
		Member2 m12 = new Member2("홍길동");
		Member2 m22 = new Member2("박동수");
		Member2 m32 = new Member2("김민수");	
		Member2[] members2 = {m12,m22,m32};

		//사용자정의 클래스타입의 배열 정렬
		Arrays.sort(members);
		//Arrays.sort(members2);//class api.arrays.Member2 cannot be cast to class java.lang.Comparable
		for(Member member : members) {
			System.out.println(member.name);
		}
		
	}

}
