package collection.list.classuser;

public class Product {
	private String name;
	private String company;
	private int price;
	
	public Product(String name, String company, int price) {
		this.name = name;
		this.company = company;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return name + "-" + company +"-" + price;
	}
}
