package com.di.no_spring_no_di;

public class NameMain {

	public static void main(String[] args) {
		// 
		NameService service = new NameService();
		service.showName("");
		NameController controller = new NameController();
		controller.show("홍길동");

	}

}
