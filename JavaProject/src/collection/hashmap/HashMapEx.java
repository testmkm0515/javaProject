package collection.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapEx {

	public static void main(String[] args) {
		// Map 컬렉션 생성
		// Map <Key, Value>
		Map<String, Integer> map = new HashMap<>();
		
		// Map의 key는 중복될 수 없음, 중복키가 put 되면 해당 key의 value가 put된 value로 수정
		
		// 객체 저장 : put(key, value)
		map.put("김길동", 85);
		map.put("홍길동", 90);
		map.put("동장군", 80);
		
		// 전체 entry 수 : size()
		System.out.println("총 entry 수  : " + map.size());
		
		// 객체 저장 : key값을 동일하게
		// map의 key 기존 entry와 동일하게 put 되면 추가가 아닌 해당 키의 value를 수정함
		// 문자열인 경우 hashCode()와 equals()메소드가 재정의되어서 동등객체 판단 기준이 포함되어 있음
		map.put("홍길동", 100);
		System.out.println("총 entry 수  : " + map.size());	
		
		// Map.get(key) : 해당 key의 value를 반환
		System.out.println("key 홍길동의 value : " + map.get("홍길동"));
		
		// Map.keySet() : 모든 entry의 key 객체를 반환(Set 타입으로 반환)
		Set<String> keySet = map.keySet();
		
		//모든 collection 관련 인스턴스는 Iterator 인터페이스를 구현해 놨음. iterator()
		//순환 관련 메서드 사용 가능
		Iterator<String> keyIt = keySet.iterator();
		
		//map의 전체 entry의 value 출력
		while(keyIt.hasNext()) {
			String key = keyIt.next();
			Integer value = map.get(key);
			System.out.println("\t" + key + ":" + value);
		}
		
		System.out.println();
		for(String key : keySet) {
			Integer value = map.get(key);
			System.out.println("\t" + key + ":" + value);			
		}
		
		//map.entrySet() : 모든 entry 반환(Set 타입으로 반환)
		System.out.println();
		Set<Entry<String,Integer>> entrySet = map.entrySet();
		
		for(Entry<String,Integer> entry:entrySet) {
			//특정 entry의 key를 추출
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("\t"+key+":"+value);
		}
		
		System.out.println();
		//모든 entry 삭제 : Map.clear()
		map.clear();
		System.out.println("총 enry 수 : " + map.size());

	}

}
