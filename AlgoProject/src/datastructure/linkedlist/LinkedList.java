package datastructure.linkedlist;

public class LinkedList {
	private ListNode head;
	
	//생성자
	public LinkedList() {
		head=null;
	}
	
	//Node 삽입(마지막에 삽입)
	public void insertNode(String data) {
		//새로운 노드 생성
		ListNode newNode = new ListNode(data);
		
		if(head==null) { //List에 노드가 없는 경우
			this.head = newNode;
		}else {//List에 노드가 1개 이상 있는 경우-마지막 노드를 찾아서 연결
			//시작노드 주소인 head의 참조주소를 임시변수에 저장
			ListNode tempNode = head;
			while(tempNode.link != null) {
				tempNode=tempNode.link;
			}
			//마지막 노드 찾았으면 link에 새로운 노드 참조하도록 연결
			tempNode.link = newNode;
		}
	}
	
	//노드 중간에 새로운 노드 삽입
	//preNode->preNode 다음노드 주소가 newNode가 참조해야하는 주소
	public void insertNode(ListNode preNode, String data) {
		ListNode newNode = new ListNode(data);
		//preNode.link = newNode; //preNode.link newNode 주소로  update된 상태에서
		newNode.link = preNode.link; //preNode.link를 newNode.link로 저장하면 나머지 리스트는 연결 불가능
		preNode.link = newNode;
	}
	
	/////////////////////////////////////////////////
	///Node 삭제
	
	//1. 중간 노드 삭제(전달된 data와 값이 동일한 node 삭제)
	//전달된 data와 값이 동일한 node중 첫번째 node 삭제
	public void deleteNode(String data) {
		ListNode preNode = head; //head참조하는 첫번째 노드의 주소
		ListNode tempNode = head.link; //첫번째 노드의 link필드의 값이 두번째 node
		
		//찾는 data가 첫번째 노드에서 찾아지는 경우
		if(data.equals(preNode.getData())) {
			head=preNode.link;//head는 두번째 node 참조
			preNode.link=null;
		}else {//두번째(tempNode) 노드부터 data가 찾아질때까지 node 이동
			while(tempNode!=null) {
				if(data.equals(tempNode.getData())){
					//데이터가 일치하는 node를 찾은 경우
					if(tempNode.link==null) { //마지막 노드에서 데이터가 일치한 경우
						preNode.link = null;//preNode는 tempNode 이전 node
					}else { // 찾은 노드가 마지막 노드가 아니면
						//preNode : 삭제 노드의 이전 노드, tempNode : 삭제할 노드
						preNode.link = tempNode.link ;
						tempNode.link = null;
					}
				}else {//데이터가 일치하지 않은 경우
					preNode = tempNode;
					tempNode = tempNode.link;
					
				}
			}
		}
		
	}
	
}










