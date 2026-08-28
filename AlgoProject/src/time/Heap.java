package time;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Heap<E> {
	private final Comparator<? super E> comparator;
	private static final int DEFAULT_CAPACITY = 10; //최소 (기본) 크기 
	
	private int size; //요소 개수
	
	private Object[] array; //heap자료 저장 배열
	
	///////////////////////////////////////
	///생성자
	///
	
	public Heap() { //초기공간 할당 없는 생성자
		this(null);
	}
	
	public Heap(Comparator<? super E> comparator) {
		this.comparator = comparator;
		this.size = 0;
		this.array = new Object[DEFAULT_CAPACITY];
	}
	
	public Heap(int capacity) {
		this(capacity, null);
	}

	public Heap(int capacity,Comparator<? super E> comparator) {
		this.comparator = comparator;
		this.size = 0;
		this.array = new Object[capacity];
	}
	
	////////////////////////////
	///  heap의 불변 성질 설정을 위한 계산 메소드
	///
	
	//부모 노드 인덱스 계산 반환
	private int getParent(int index) {
		return index/2;
	}
	//왼쪽 자식 노드 인덱스 계산 반환
	private int getLeftChild(int index) {
		return index * 2;
	}	
	//오른쪽 자식 노드 인덱스 계산 반환
	private int getRightChild(int index) {
		return index * 2 +1;
	}
	
	/////////////////////////////
	/// resize 
	/// 새로운 용량을 파라미터로 받는다
	///
	private void resize(int newCapacity) {
		//배열 새로 생성
		Object[] newArray = new Object[newCapacity];
		
		//새 배열에 기존에 있던 배열 요소들을 모두 복사 함
		for(int i=1; i <= size; i++) {
			newArray[i] = array[i];
		}
		
		/*
		 * 기존 배열 객체 연결 끊고(null) 새 배열 연결
		 */
		this.array = null;
		this.array = newArray;
	}
	
	//////////////////////////////
	/// heap에 자료 저장 -> add(target) -> shiftUp(size, target(저장할값)) 
	///
	public void add(E value) {
		//배열이 꽉 차있을경우 현재 크기의 두배로 확장
		if(size + 1 == array.length) {
			resize(array.length * 2);
		}
		//인덱스 계산을 위해 배열은 1번 idx부터 사용
		shiftUp(size+1, value);//추가되는 위치와 넣을 값을 전달
		size++; //정상적으로 추가 후 재배치가 끝나면 사이즈를 증가			
	}
	
	/////
	///idx : 추가위치, target : 저자할 값
	///
	private void shiftUp(int idx, E target) {
		if(comparator != null) {
			shiftUpComparator(idx, target, comparator);
		}else {
			shiftUpComparable(idx, target);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void shiftUpComparator(int idx, E target, Comparator<? super E> comp) {
			while(idx > 1) {
				int parent = getParent(idx);
				Object parentVal = array[parent]; //부모노드 값 추출
				
				//타겟노드값(기준)과 부모노드값 비교 : 1 또는 0은 기준객체가 더 큼
				if(comp.compare(target, (E)parentVal)>=0) {
					//교환필요 없이 현재 위치에 저장
					break;
				};
				// 비교 결과가 음수면
				// 부모노드가 타켓 노드보다 크면
				// 현재 위치의 값을 부모노드값으로 교체 타겟 노드 위치를 부모노드 위치로 변경
				array[idx] = parentVal;
				idx = parent;
			}
			//반복을 종료하면 target의 최종 위치가 정해짐 : idx
			array[idx] = target;
				
	}
	
	@SuppressWarnings("unchecked")
	private void shiftUpComparable(int idx, E target) {
		//Comparable 사용위해 기준객체 타입을 Comparable 타입으로 형변환		
		Comparable<? super E> comp = (Comparable<? super E>)target;
		
		while(idx > 1) {
			int parent = getParent(idx);
			Object parentVal = array[parent]; //부모노드 값 추출
			
			//타겟노드값(기준)과 부모노드값 비교 : 1 또는 0은 기준객체가 더 큼
			if(comp.compareTo((E)parentVal)>=0) {
				//교환필요 없이 현재 위치에 저장
				break;
			};
			// 비교 결과가 음수면
			// 부모노드가 타켓 노드보다 크면
			// 현재 위치의 값을 부모노드값으로 교체 타겟 노드 위치를 부모노드 위치로 변경
			array[idx] = parentVal;
			idx = parent;
		}
		//반복을 종료하면 target의 최종 위치가 정해짐 : idx
		array[idx] = comp;		
	}
	
	///////////////////////////////
	/// remove 메서드
	/// heap은 root 노드를 삭제함
	/// root 노드 삭제 후 heap 재구성
	/// remove() -> shiftDown(idx, target)
	@SuppressWarnings("unchecked")
	public E remove() {
		if(array[1] == null) {	// 만약 root가 비어있을경우 예외를 던지도록 함
			throw new NoSuchElementException();
		}
    
		E result = (E) array[1];	// 삭제된 요소를 반환하기 위한 임시 변수 
		E target; // 타겟이 될 요소
		if(size == 1) {
			target = null;
		}
		else {
			target = (E) array[size];
		}
		array[size] = null;	// 타겟 노드를 비운다.
		
		// 삭제할 노드의 인덱스와 이후 재배치 할 타겟 노드를 넘겨준다.
		shiftDown(1, target);	// 루트 노드가 삭제되므로 1을 넘겨준다.
		
		return result;
	}
	
	private void shiftDown(int idx, E target) {
		if(comparator != null) {
			shiftDownComparator(idx, target, comparator);
		}else {
			shiftDownComparable(idx, target);
		}
	}
	@SuppressWarnings("unchecked")
	private void shiftDownComparator(int idx, E target, Comparator<? super E> comp) {
		//삭제할 index의 노드를 삭제
		array[idx] = null;
		size--;
		
		int parent = idx;
		int child;
		
		while((child = getLeftChild(parent)) <= size) {
			int right = getRightChild(parent);
			Object childVal = array[child]; //타겟과 비교할 값
			
			//왼쪽 자식노드 값이 오른쪽 자식노드 값보다 크면 childVal 값을 변경
			if(right <= size && comp.compare((E)childVal, (E)array[right])>0) { //childVal 값이 큼
				child = right;
				childVal = array[child];
			}
			
			//target 값이 자식노드 값보다 작으면 반복문을 종료
			if(comp.compare(target, (E) childVal) <= 0) {
				break;
			}
			
			//자식노드값보다 target이 크면
			array[parent] = childVal;
			parent = child;
		}
		
		//반복문 종료 후 target의 위치가 정해짐(parent)
		array[parent] = target;
		
		/*
		 * 삭제후에는 배열 사이즈가 기본 크기인 10보다는 크고 요소 개수가 전체 배열 크기의 1/4일 경우
		 * 배열 사이즈를 반으로 줄임 
		 */
		if(array.length > DEFAULT_CAPACITY && size < array.length/4) {
			resize(Math.max(DEFAULT_CAPACITY, array.length/2));
		}
		
	}
	@SuppressWarnings("unchecked")
	private void shiftDownComparable(int idx, E target) {
		
		Comparable<? super E> comp = (Comparable<? super E>) target;		
		array[idx] = null;
		size--;
		
		int parent = idx;
		int child; 		
		
		while((child = getLeftChild(parent)) <= size) {
			
			int right = getRightChild(parent);
			Object childVal = array[child]; //타겟과 비교할 값
			
			//왼쪽 자식노드 값이 오른쪽 자식노드 값보다 크면 childVal 값을 변경
			if(right <= size && ((Comparable<? super E>)childVal).compareTo((E)array[right])>0) { //childVal 값이 큼
				child = right;
				childVal = array[child];
			}
			
			//target 값이 자식노드 값보다 작으면 반복문을 종료
			if(comp.compareTo((E) childVal) <= 0) {
				break;
			}
			
			//자식노드값보다 target이 크면
			array[parent] = childVal;
			parent = child;
		}
		
		//반복문 종료 후 target의 위치가 정해짐(parent)
		array[parent] = target;
		
		/*
		 * 삭제후에는 배열 사이즈가 기본 크기인 10보다는 크고 요소 개수가 전체 배열 크기의 1/4일 경우
		 * 배열 사이즈를 반으로 줄임 
		 */
		if(array.length > DEFAULT_CAPACITY && size < array.length/4) {
			resize(Math.max(DEFAULT_CAPACITY, array.length/2));
		}
	}
	
	public int size() {
		return this.size;
	}
	
	@SuppressWarnings("unchecked")
	public E peek() {
		if(array[1] == null) {
			throw new NoSuchElementException();
		}
		return (E)array[1];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public Object[] toArray() {
		return Arrays.copyOf(array, size+1);
	}
 	
}




























































