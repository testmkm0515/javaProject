package sort;

import java.util.LinkedList;
import java.util.Queue;

public class RadixSort {
	//10진수 기준으로 구현
	private static int BUCKET_NUM = 10;
	
	public static void sort(int[] arr) {
		//버킷 생성
		Queue<Integer>[] bucket = new LinkedList[BUCKET_NUM];
		
		for(int i=0; i<BUCKET_NUM; i++) {
			bucket[i] = new LinkedList<>();
		}
		
		//정렬 대상에서 가장 자리수가 큰 수의 자리수 반환
		int maxLen = maxDigitCount(arr);
		int digitNumber = 0;
		int arrIndex=0;
		
		//자리수 만큼 버킷에 넣고 빼기
		for(int i=0; i<maxLen; i++) {
			//데이터 수 만큼 반복 (특정 자리수값을 기준으로 한 정렬)
			for(int j=0; j<arr.length; j++) {
				digitNumber = getDigit(arr[j],i); //현재 원소값의 지정된 자리수 값을 반환 123, i==0 -> 3
				//버킷을 결정해서 저장
				bucket[digitNumber].add(arr[j]);
			}
			
			//버킷에 들어간 데이터를 순서대로 꺼내서 배열에 덮어씌움
			for(int j=0; j<BUCKET_NUM; j++) {
				while(!bucket[j].isEmpty()) {
					arr[arrIndex++] = bucket[j].remove();
				}
			}
			arrIndex=0;
		}
		
	}
	
	//숫자의 특정 자리수에 대한 값을 반환 
	//getDigit(123,0)->3 (123/1)%10
	//getDigit(123,1)->2 (123/10)%10
	//getDigit(123,2)->1 (123/100)%10
	private static int getDigit(int num, int index) {
		return(int)Math.floor(Math.abs(num)/Math.pow(10, index)) % 10;
	}
	
	/*
	 * 숫자의 자리수 구하기
	 * digitCount(10) ->2
	 * digitCount(100) ->3
	 * digitCount(1) ->1
	 * 
	 * log10(10) -> 1
	 * log10(100) -> log10(10^2) -> 2
	 */
	private static int digitCount(int num) {
		if(num == 0) {
			return 1;
		}
		
		return (int)Math.floor(Math.log10(Math.abs(num))) + 1;
	}
			
	
	private static int maxDigitCount(int[] arr) {
		int max = 0;
		//정렬해야하는 원소의 자리수를 구해서 배열에 저장 후 가장 큰 값을 찾아서 반환		
		for(int i=0; i<arr.length; i++) {
			max = Math.max(max, digitCount(arr[i]));
		}
		return max;
	}
}










