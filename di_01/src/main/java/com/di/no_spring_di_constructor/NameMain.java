package com.di.no_spring_di_constructor;

public class NameMain {

	public static void main(String[] args) {
		// 개발코드에서 NameService 객체 생성 후 NamerController 객체 생성시 주입(전달)
		NameService service = new NameService();
		NameController controller = new NameController(service);
		controller.show("홍길동");

	}

}
