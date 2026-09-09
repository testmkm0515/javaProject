package com.di.no_spring_di_constructor;

public class NameController {
	//NameController입장에서 NameService는 의존관계임
	//결합방식이 아닌 생성자를 통해서 주입받음	
	NameService nameService;
	//NameService nameService = new NameService(); //결합방식
	public NameController(NameService nameService) { //생성자 매개변수에 파라미터값 전달
		//객체가 전달되는 개념을 객체 주입(전달)되어서 조립(대입) : DI
		this.nameService = nameService;
	}
	public void show(String name) {
		System.out.println("NameController : "  + nameService.showName(name));
	}
}
