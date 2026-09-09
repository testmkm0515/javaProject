package com.di.spring_di_xml_setter;

public class NameController {
	//NameController입장에서 NameService는 의존관계임
	//setter 통해 객체 주입(DI) -> 생성자는 기본 생성자 외에 추가되면 안됨
	NameService nameService;
	
	public void setNameService(NameService nameService) { //setter 통한 DI
		this.nameService = nameService;
	}
	
	public void show(String name) {
		System.out.println("NameController : "  + nameService.showName(name));
	}
}
