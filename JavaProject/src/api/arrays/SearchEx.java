package api.arrays;

import java.util.Arrays;

public class SearchEx {

	public static void main(String[] args) {
		// binarySearch(배열, 찾을 값), 사용전에 sort 후 사용 오름차순 정렬 후 사용
		// 기본 타입값
		int[] scores = {99,97,98};
		Arrays.sort(scores);
		int index = Arrays.binarySearch(scores, 99);
		System.out.println("찾은 인덱스 : "+index);
		
		// 문자열 검색
		String[] names = {"홍길동", "박동수", "김민수"};
		Arrays.sort(names);
		index = Arrays.binarySearch(names, "홍길동");
		System.out.println("찾은 인덱스 : "+index);	
		
		// 사용자 정의 객체 검색
		Member m1 = new Member("홍길동");
		Member m2 = new Member("박동수");
		Member m3 = new Member("김민수");
		Member[] members = {m1,m2,m3};		
		Arrays.sort(members);
		index = Arrays.binarySearch(members, m1);
		System.out.println("찾은 인덱스 : "+index);			

	}

}
