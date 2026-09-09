package com.di.no_spring_di_setter;

public class NameController {
	//NameController입장에서 NameService에 종속적(의존관계)
	NameService nameService;
	//NameService nameService = new NameService(); //결합방식
	//setter 통한 주입
	public void setNameService(NameService nameService) {
		this.nameService = nameService;
	}
	public void show(String name) {
		System.out.println("NameController : "  + nameService.showName(name));
	}
}
