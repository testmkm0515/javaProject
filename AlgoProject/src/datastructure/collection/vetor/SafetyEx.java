package datastructure.collection.vetor;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SafetyEx {

	public static void main(String[] args) {
		// 스레드 동기화를 지원하는 vector콜렉션
		
		List<Integer> list = new Vector<>();
		int threadCount = 1000;
		
		try {
			ExecutorService executorService = Executors.newFixedThreadPool(32);
			
			for (int i=0; i<threadCount;i++) {
				final int value = i; 
				executorService.submit(()->{
					list.add(value); 
				});
			}	
			
			executorService.shutdown(); 
			executorService.awaitTermination(5, TimeUnit.SECONDS);		
			
			System.out.println("목표 크기 : " + threadCount);
			System.out.println("실제 리스트 크기 : " + list.size());	
			//Vector는 스레드 동기화가 처리된 클래스이므로 동시성 문제 발생하지 않음
			//스레드환경에서는 Vector를 사용함
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
