package datastructure.collection.hashmap;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class HashMapWordCount {

	public static void main(String[] args) {
		// WordCount
		Scanner scanner = new Scanner(System.in);
		System.out.println("문장을 입력하세요. ");
		String text = scanner.nextLine();
		
		String[] sentences = text.split("\\.");
		System.out.println(Arrays.toString(sentences));
		System.out.println(sentences.length);
		
		//문장을 단어로 분리해서 담을 배열 및 word count를 할 HashMap 생성
		String [][] textArray = new String[sentences.length][];
		HashMap<String, Integer> wordCount = new HashMap<>();
		
		//문장을 단어로 분리
		for(int i=0; i<sentences.length; i++) {
			textArray[i] = sentences[i].trim().split(" ");
			System.out.println(Arrays.toString(textArray[i]));
		}
		
		//단어 세기
		for(int i=0; i<sentences.length;i++) {
			for(int j=0; j<textArray[i].length; j++) {
				if(!textArray[i][j].isEmpty()) {
					String word = textArray[i][j] //한단어 추출해서
							.replaceAll("[^a-zA-Z]", "")//영문자 제외한 나머지 문자 제거
							.toLowerCase();//모든 문자 소문자로
					
					//단어(word)를 key로 빈도수를 value로 저장
					//map.getOrDefault(key, 기본값) -> key가 map에 있으면 vlaue를 반환, 없으면 기본값을 반환
					//map의 key가 있을때 put은  value update
					//기존값 반환받아 1 증가 후 update, 키가 없는 경우 0을 반환받아 1 증가후 put
					wordCount.put(word, wordCount.getOrDefault(word, 0)+1);
				}
			
			}
		}
		
		//Map 출력 : key value를 set으로 추출 후 key(단어) : value(빈도수) : 전체대비백분율
		//전체 대비 백분율 위해서 value의 합을 구함
		//HashMap.values() : collection(V) 타입으로 반환
		//stream() : 배열, 컬렉션등의 데이터를 람다식 활용 함수형으로 처리하게 해주는 도구
		// 중간연산은 stream 반환 최종연산은 기본값 또는 객체로 결과 반환
		//HashMap.values()-> stream 처리 -> Integer 객체로 반환
		//mapToint(Integer::intValue) : 기본형 int로 변환처리 
		
		int size = wordCount.values().stream().mapToInt(Integer::intValue).sum();
		
		System.out.println("Word counts");
		System.out.println("words : count : percentage");
		
		for(Map.Entry<String, Integer> entry : wordCount.entrySet()) {
			System.out.printf("%s : %d : %.2f%%\n", entry.getKey(),entry.getValue(),(((double)entry.getValue()/size)*100));
			}
		
		//단어 빈도에 따른 통계 출력 : 전체 단어수:value의 합/고유 단어수 : key의 수 -> size()는 entrySet의 수 반환
		//빈도가 가장 높은 단어/빈도가 가장 낮은 단어
		
		System.out.println("===========Statistics==============");
		System.out.println("Statistics : Total word count - "+size+"단어");
		System.out.println("Statistics : Number of unique words - "+wordCount.size()+"단어");
		
		//max, min을 위한 비교함수 구현
		//두개의 entry 비교 Comparator 인터페이스 구현(익명 객체 사용)
		Comparator<Entry<String, Integer>> comparator = new Comparator<Entry<String,Integer>>(){
			@Override
			public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
				//비교하려는 value가 Integer고 Integer는 compareTo가 구현되어 있음
				return e1.getValue().compareTo(e2.getValue());
			}
		};
		
		//EntrySet을 전달해서 Collection.max/min을 적용하면 Entry 타입으로 반환
		Entry<String, Integer> maxEntry = Collections.max(wordCount.entrySet(),comparator);
		Entry<String, Integer> minEntry = Collections.min(wordCount.entrySet(),comparator);
		
		System.out.println("Statistics : Max of words - " + maxEntry.getKey() + " : " + maxEntry.getValue());
		System.out.println("Statistics : Min of words - " + minEntry.getKey() + " : " + minEntry.getValue());
		
	}

}





