package exam.sort.merge;

public class MergeSort { //정렬을 위한 공간이 하나 더 필요한 정렬
	//정렬동안에 정렬하여 원소를 담을 임시공간
	private static int[] sorted;
	
	public static void mergeSort(int a[]) {
		sorted = new int[a.length];
		mergeSort(a, 0, a.length-1);
		sorted = null;
	}
	
	private static void mergeSort(int[] a, int left, int right) {
		/*
		 * left==right 즉, 부분리스트가 1개의 원소만 갖고 있는 경우
		 * 더이상 쪼갤 수 없을 때 return
		 */
		
		if(left == right) return ;
		
		//분할하고 결합하는 과정을 반복
		int mid = (left + right)/2; //절반위치
		mergeSort(a,left, mid);
		mergeSort(a,mid+1, right);
		
		merge(a, left, mid, right); //병합작업 메소드 호출
	}
	
	/*
	 * 결합할 부분 리스트는 a배열의 left~right 까지
	 * 
	 * a : 정렬할 배열
	 * left : 배열의 시작
	 * right : 배열 끝
	 * mid : 배열의 중간점
	 */
	private static void merge(int[] a, int left, int mid, int right) {
		int l = left; //왼쪽 부분리스트의 시작점
		int r = mid + 1;      //오른쪽 부분 리스트의 시작점 
		int idx = left ; //정렬 결과를 넣은 idx
		
		//각 부분리스트의 끝점을 지나지 않는동안 반복
		//왼쪽 리스트와 오른쪽 리스트들을 비교
		while(l <= mid && r<= right) {
			/*
			 * 왼쪽 부분리스트의 첫번째 원소 값이 더 작으면 임시배열에 왼쪽 부분 리스트의 원소를 저장
			 * 정렬이 종료된 원소 다음 원소로 l++, 임시배열 idx로 ++
			 */
			if(a[l]<=a[r]) {
				sorted[idx] = a[l];
				idx++;
				l++;
			}else {
				/*
				 * 오른쪽 부분리스트의 첫번째 원소 값이 더 작으면 임시배열에 오른쪽 부분 리스트의 원소를 저장
				 * 정렬이 종료된 원소 다음 원소로 r++, 임시배열 idx로 ++
				 */				
				sorted[idx] = a[r];
				idx++;
				r++;
			}
		}
		//위 반복문 종료 후 왼쪽 또는 오른쪽 리스트 중 남는 원소가 있게 됨
		/* 왼쪽 리스트는 임시 배열에 모두 저장됨
		 * 오른쪽 리스트에서 남은 원소를 임시배열로 저장
		 */
		if(l>mid) {
			while(r <= right) { // 오른쪽 리스트에 원소가 남아 있는 동안
				sorted[idx] = a[r];
				r++;
				idx++;
			}
		}
		/* 오른쪽 리스트는 임시 배열에 모두 저장됨
		 * 왼쪽 리스트에서 남은 원소를 임시배열로 저장
		 */
		else {
			while(l<=mid) {
			sorted[idx] = a[l];
			l++;
			idx++;
			}
		}
		
		/*
		 * 임시배열에 정렬된 결과를 기존의 배열에 복사하여 옮겨준다
		 */
		
		for(int i=left ; i<= right; i++) {
			a[i] = sorted[i];
		}
	}
}











