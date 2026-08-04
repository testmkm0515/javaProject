package collection.list.classuser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrdListMain {

	public static void main(String[] args) {
		// 사용자 정의 객체 list로 저장
		List<Product> list = new ArrayList<Product>();
		
		Product p1 = new Product("모니터","LG",250000);
		Product p2 = new Product("마우스","로지텍",25000);
		Product p3 = new Product("키보드","삼성",30000);
		
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		System.out.println(list.size());
		System.out.println();
		
		for(int i=0; i<list.size(); i++) {
			Product p = list.get(i);
			System.out.println(p);
		}
		
		System.out.println();
		
		for(Product p : list) {
			System.out.println(p);
		}		
		
		//Iterator 클래스 사용
		System.out.println();
		
		Iterator<Product> it = list.iterator();
		while(it.hasNext()) {
			Product p = it.next();
			System.out.println(p);
		}
	}

}
