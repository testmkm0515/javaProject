package extendsex.instarray;

public class Goods {
	String name;
	int price, stock, sold;
	
	
	public Goods(String name, int price, int stock, int sold) {
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.sold = sold;
	}
	
	public void showGoodsInfo() {
		System.out.print(name + " ");
		System.out.print(price + " ");
		System.out.print(stock + " ");
		System.out.print(sold + " ");
		System.out.println();
	}
}
