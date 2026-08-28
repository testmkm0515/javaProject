package datastructure.tree.binarysearch;

import java.util.Comparator;


public class BinarySearchTree<E> {
	private Node<E> root; //루트(최상단)노드
	private int size; //요소(노드)의 개수
	
	private final Comparator<? super E> comparator; //<? super E> 제네릭타입 E와 E의 모든 부모 클래스 포함
	
	//type에 비교정의객체가 구현되어 있는 타입인 경우
	public BinarySearchTree() {
		this(null);
	}
	//type에 비교정의객체가 미구현 타입인 경우에는 Comparator인터페이스를 구현한 구현객체가 전달되어야 함
	public BinarySearchTree(Comparator<? super E> comparator) {
		this.comparator = comparator;
		this.root = null;
		this.size=0;
	}
	
	/*
	 * 노드 추가를 위한 addUsingXXX()메소드는 반환 타입이 E 타입임
	 * 중복원소를 삽입 할 경우 해당 value를 반환하고 삽입이 완료되면 null을 반환함
	 */
	public boolean add(E value) {
		if(comparator == null) {
			return addUsingComparable(value)==null;
		}
		return addUsingComparator(value, comparator)==null;
	}
	
	//전달되는 객체에 따라 Comparable 또는 Comparator중 하나의 사용이 가능하도록 2개 메서드 생성
	
	//Comparable을 이용한 add 메소드
	private E addUsingComparable(E value) {
		Node<E> current = root; //탐색할 노드를 가리키는 current
		Node<E> currentParent; //current 직전의 탐색 노드를 가리키는 노드
		//삽입할 노드가 비교 될 수 있도록 변수 생성(add 대상의 value가 비교가능하도록 Comparable 타입으로 변환
		@SuppressWarnings("unchecked")
		Comparable<? super E> compValue   = (Comparable<? super E>) value; //기준객체.compareTo(비교객체)
		int compResult; //비교결과 (양수, 음수, 0)
		
		//current가 null 즉, root가 null이면 root에 새노드 연결 후 null 반환
		if(current == null) {
			root = new Node<E>(value);
			size++;
			return null; //노드 추가 완성 시 null 반환
		}
		
		//기존 트리에 노드가 1개 이상 있는 경우 방향을 결정 삽입될 위치 결정
		do {
			//삽입 위치를 유지하는 변수 update
			currentParent = current;
			//새로운 노드의 값과 현재 노드의 값 비교
			compResult = compValue.compareTo(current.value);
			//비교결과에 따라 방향 결정, 동일하면 value 그대로 return
			if(compResult < 0) {//새로운 노드 value가 현재 value보다 작음
				current = current.left;
			}else if(compResult > 0) {//새로운 노드 value가 현재 value보다 큼
				current = current.right;
			}else {
				return value;				
			}			
		}while(current != null);
		
		//순회가 완료 되어서 삽입해야 할 위치를 찾았다면 value를 노드로 구성
		Node<E> newNode = new Node<>(value, currentParent); //부모노드 링크에값을 전달하는 예시
		//Node<E> newNode = new Node<>(value);
		if(compResult < 0) {
			currentParent.left = newNode;
		}else {
			currentParent.right = newNode;
		}
		
		size++;
		return null; //add가 성공함
	}
	
	//Comparator를 이용한 add 메소드 - Comparable 이용한 메소드와 비교 메소드만 다르고 다른 절차는 동일함
	private E addUsingComparator(E value, Comparator<? super E> comp) {
		Node<E> current = root;
		Node<E> currentParent; 
		int compResult; 

		if(current == null) {
			root = new Node<E>(value);
			size++;
			return null; 
		}		
		//기존 트리에 노드가 1개 이상 있는 경우 방향을 결정 삽입될 위치 결정
		do {
			currentParent = current;
			//전달된 comparator이용 비교 진행 - compare(obj1, obj2)
			compResult = comp.compare(value,current.value);

			if(compResult < 0) {
				current = current.left;
			}else if(compResult > 0) {
				current = current.right;
			}else {
				return value;				
			}			
		}while(current != null);

		Node<E> newNode = new Node<>(value, currentParent); 
		//Node<E> newNode = new Node<>(value);
		if(compResult < 0) {
			currentParent.left = newNode;
		}else {
			currentParent.right = newNode;
		}
		
		size++;
		return null; //add가 성공함		
	}	
	
	///////////////////////////////////////////////////////////////////////////////
	/// 삭제(remove) 메서드
	
	public E remove(E value) {
		if(comparator == null) {
			return removeUsingComparable(value);
		}
		return removeUsingComparator(value, comparator);
	}
	
	//Comparable을 이용한 삭제 메소드
	private E removeUsingComparable(E value) {
		Node<E> currentParent = null;
		Node<E >current = root;
		boolean hasLeft = false;
		int resComp;
		
		//current(root)가 null인 경우
		if(root==null) {
			return null;
		}
		
		@SuppressWarnings("unchecked")
		Comparable<? super E> compValue = (Comparable<? super E>)value;
		//삭제할 node를 찾는 역할을 함, current.value와 compValue가 동일하면 삭제 노드를 찾게 됨, 찾으면 break
		//current가 null이면 해당 value의 node가 없음
		do {
			resComp = compValue.compareTo(current.value);
			if(resComp == 0) { //삭제할 node 찾음
				break;
			}
			
			//삭제할 node 못찾음
			currentParent = current;
			if(resComp < 0) {
				hasLeft = true;
				current=current.left;
			}else {
				hasLeft = false;
				current = current.right;
			}			
		}while(current != null);
		
		if(current == null) { //찾는값이 없음
			return null; //삭제 실패
		}
		
		if(currentParent == null) {//찾는값이 root에 있음
			deleteNode(current); //deleteNode->node 삭제 후 재배치 역할
			size--;
			return value;
		}
		
		if(hasLeft) { //true면 currentParent의 왼쪽 노드가 삭제 되었음
			currentParent.left = deleteNode(current);
		}else {//currentParent의 오른쪽 노드가 삭제 되었음
			currentParent.right = deleteNode(current);
		}
		
		size--;
		return value;
		
	}
	
	//Comparator을 이용한 삭제 메소드
	private E removeUsingComparator(E value, Comparator<? super E> comp) {
		
		E res = null;
		return res;
	}
	
	// 실제 노드를 삭제하는 메소드, 삭제 후 대체 되고 난 뒤의 위치 노드를 반환
	// 삭제 후 재 배치된 삭제 노드의 자식노드의 참조를 반환
	private Node<E> deleteNode(Node<E> removeNode){
		if(removeNode != null) {
			if(removeNode.left == null && removeNode.right == null) { //삭제하려는 노드가 단말
				if(removeNode==root) {
					root = null;
				}else {
					removeNode=null;
				}
				return null;
			}
			
			if(removeNode.left != null && removeNode.right !=null) {//삭제하려는 노드의 양쪽 자식노드가 있음
				//삭제하려는 node의 값을 다른 값으로 대체
				//대체값 결정 방법 
				//- 왼쪽 서브트리에서 제일 큰값의 노드로 대체
				//- 오른쪽 서브트리에서 제일 작은값의 노드로 대체
				Node<E> replacement = getSuccessorAndUnlink(removeNode);
				removeNode.value = replacement.value;
			} else if (removeNode.left != null) {//삭제할 노드의 왼쪽 자식 노드만 있는 경우
				if(removeNode==root) {
					removeNode = removeNode.left; 
					root = removeNode;
				}else {
					removeNode=removeNode.left; //삭제할 노드의 왼쪽 자식 노드로 업데이트
				}
			}else {//삭제할 노드의 오른쪽자식 노드만 있는 경우
				if(removeNode==root) {
					removeNode = removeNode.right; 
					root = removeNode;
				}else {
					removeNode=removeNode.right; //삭제할 노드의 오른쪽 자식 노드로 업데이트
				}				
			}
		}
		return removeNode; //삭제된 자리 대체할 노드의 참조		
	}
	
	/*
	 * 삭제되는 노드의 자리를 대체할 노드(후계자)를 찾는 메소드
	 * 오른쪽 서브트리에서 가장 작은 값의 노드를 찾음
	 * 
	 * @param node 삭제되는 노드(= 대체되어야할 노드)
	 * @return 대체할 노드
	 */
	private Node<E> getSuccessorAndUnlink(Node<E> node){
		Node<E> currentParent = node;
		Node<E> current = node.right;
		
		if(current.left == null) {//현재 노드의 왼쪽 자식노드가 없으면 현재 노드가 가장 작은 값의 노드
			//가장 작은값의 노드의 오른쪽 자식노드를 부모 노드의 오른쪽 자식으로 연결
			currentParent.right = current.right;
			current.right = null;
			return current;
		}
		
		//current의 왼쪽 노드가 null이 아님 -> 가장 작은값의 노드를 찾기(왼쪽으로 이동)
		while(current.left != null) {
			currentParent = current;
			current = current.left;
		}
		//반복문 종료 후 current에 가장 작은값의 노드가 참조됨, current의 왼쪽 노드 없음
		currentParent.left = current.right;
		current.right = null;
		return current;
	}
	
	/*
	 * 이진탐색트리에있는 원소 개수 반환
	 */
	public int size() {
		return this.size;
	}
	
	/*
	 * 이진 탐색트리가 비어있는지를 판단하는 메서드
	 */
	public boolean isEmpty() {
		return size() == 0;
	}
	
	/*
	 * 이진탐색트리내에 찾고자 하는 객체가 존재하는지를 판단하는 메서드
	 */
	public boolean contains(Object o) {
		if(comparator == null) {
			return containsUsingComparable(o);
		}
		return containsUsingComparator(o, comparator);
	}
	
	/*
	 * 이진트리는 대소관계로 방향이 결정되므로 비교 결과에 따라 
	 * 왼쪽 또는 오른쪽 노드로 이동하면서 비교
	 */
	private boolean containsUsingComparable(Object o) {
		@SuppressWarnings("unchecked")
		Comparable<? super E> value = (Comparable<? super E>) o;
		
		Node<E> node = root;
		
		while(node != null) { //객체가 찾아지면 true 리턴
			int res = value.compareTo(node.value);
			if(res>0) {
				node = node.right;
			}else if(res<0) {
				node = node.left;
			}else { //res==0 : 객체를 찾음
				return true;
			}
		}
		//반복문이 종료되어도 return이 안되었다면 객체가 없음을 의미함
		return false;
	}
	
	private boolean containsUsingComparator(Object o, Comparator<? super E> comp) {
		
		return false;
	}
	
	//이진 탐색 트리 초기화
	public void clear() {
		size = 0;
		root = null;
	}
	
	/*
	 * 전위순회(root->left->right)
	 */
	public void preorder() {
		preorder(this.root);
	}
	
	public void preorder(Node<E> o) {
		//node o가 null이 아닌동안 재귀호출
		if( o != null ) {
			System.out.print(o.value +  " "); //root 
			preorder(o.left);
			preorder(o.right);
		}
	}
	
	/*
	 * 중위순회(left->root->right)
	 */
	public void inorder() {
		inorder(this.root);
	}
	
	public void inorder(Node<E> o) {
		if( o != null) {
			inorder(o.left);
			System.out.print(o.value +  " ");
			inorder(o.right);
		}
	}	
	
	/*
	 * 후위순회(left->right->root)
	 */
	public void postorder() {
		postorder(this.root);
	}
	
	public void postorder(Node<E> o) {
		if(o != null) {
			postorder(o.left);
			postorder(o.right);
			System.out.print(o.value + " ");
		}
	}
}






























