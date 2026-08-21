package sort;

/*
 * 퀵정렬
 * pivot이라는 기준값을 결정해서 pivot 기준 두개의 부분 리스트로 나눔
 * 작은 /pivot/ 큰
 * 비교하면서 데이터를 찾기 때문에 비교정렬
 * 정렬 대상 데이터외에 추가적인 공간을 필요로 하지 않는다 : in-palce sort
 * 
 * 1. pivot 선택
 * 2. pivot 기준 - 왼쪽에서부터는 피벗보다 큰 값을 오른쪽에서부터는 피벗보다 작은값을 찾는다
 * 3. 양방향에서 찾아지면 교환한다
 * 4. 양쪽 위치 idx가 서로 교차되지 않을때까지 2,3번 반복
 * 5. 교차지점을 기준으로 두 개의 부분리스트로 나누고 각 부분리스트에 퀵정렬 과정(1~4)을 반복(Divide)
 * 6. 인접한 부분리스트끼리 합친다 (Conqure)
 * 
 * pivot 선택하는 방법
 * 현재 부분리스트의 가장 왼쪽 원소가 피벗
 * 현재 부분리스트의 가장 오른쪽 원소가 피벗
 * 현재 부분리스트의 중간 원소가 피벗
 */
public class QuickSort {
	public static void sort(int[] a) {
		l_pivot_sort(a,0, a.length-1);
	}
	
	/*
	 * 왼쪽 피벗 선택 방식
	 * @param a : 정렬할 배열
	 * @param lo : 현재 부분 리스트 왼쪽 원소 인덱스
	 * @param hi : 현재 부분 리스트 오른쪽 원소 인데스
	 */
	private static void l_pivot_sort(int[] a, int lo, int hi) {
		if(lo >= hi) {//정렬할 원소가 없거나 1개
			return;
		}
		
		//두개의 리스트로 분할 후 pivot을 반환
		int pivot = partition(a, lo, hi);
		l_pivot_sort(a,lo, pivot-1);
		l_pivot_sort(a,pivot+1, hi);
	}
	
	/*
	 * pivot을 기준으로 파티션을 나누기 위한 약한 정렬 메서드
	 * 
	 * @param a : 정렬할 배열
	 * @param left : 현재 부분 리스트  가장 왼쪽 원소 인덱스
	 * @param right : 현재 부분 리스트  가장 오른쪽 원소 인덱스
	 * return : 최종적으로 위치한 피벗의 위치(lo)를 반환
	 */
	private static int partition(int[] a, int left, int right) {
		int lo = left;
		int hi = right;
		int pivot = a[left]; //부분 리스트의 왼쪽 요소를 피벗으로 설정
		
		//피벗과 부분리스트 원소와 대소 비교, lo가 hi보다 작은동안
		while(lo < hi) {
			
			/*
			 * hi가 lo보다 크면서 hi요소가 pivot보다 작거나 같은 원소를 찾을때 까지
			 * hi를 감소 시킨다
			 */
			while(a[hi] > pivot && lo < hi) { //height 포인터가 피벗보다 작은값을 찾은게 아니라면 현재 원소는 skip
				hi--;
			}
			
			/*
			 * hi가 lo보다 크면서 lo의 요소가 pivot보다 큰 원소를 찾을때가지
			 * lo를 증가
			 */
			while(a[lo] <= pivot && lo < hi) { 
				lo++;
			}
			
			swap(a, lo, hi);			
		}
		
		/*
		 * pivot으로 설정했던 위치(a[left])의 원소와 lo가리키는 원소를 교환하고 lo지점을 pivot위치로 결정
		 */
		swap(a, left, lo);
		
		return lo;		
	}
	
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}















