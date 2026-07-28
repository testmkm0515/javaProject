package extendsex.instarray;

import java.util.Scanner;

public class GoodsMain {

	public static void main(String[] args) {
		// 객체 배열(생성자 매개변수)
		Scanner sc = new Scanner(System.in);
		String name;
		int price, stock, sold;
		
		Goods[] g = new Goods[3];
		
		System.out.println("**** 상품정보 입력 ****");
		for(int i=0; i<g.length; i++) {
			System.out.print("\n상품명 : ");
			name = sc.next();
			System.out.print("가격 : ");
			price = sc.nextInt();
			System.out.print("판매량 : ");
			sold = sc.nextInt();
			System.out.print("재고량 : ");
			stock = sc.nextInt();
			//객체 생성 시 생성자 호출되면서 인수값 전달
			g[i] = new Goods(name, price, stock, sold);
			
		}
		System.out.println("**** 상품정보 출력 ****");
		for(int i=0; i<g.length; i++) {
			g[i].showGoodsInfo();
		}		

	}

}









