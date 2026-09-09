package com.di.spring_di_annotation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import javax.annotation.Resource;

public class NameController {
	//NameController입장에서 NameService는 의존관계임
	//DI anotherNameService bean을 주입 - 타입이 동일한 bean이 여러개 있을경우 특정 bean을 선택할 수 있음
	//@Autowired
	//@Qualifier("anotherNameService")
	//@Resource(name="anotherNameService") //Autowired,Qualifier를 같이사용하는것과 같은 결과
	//@Resource  
	INameInterface nameService; //name속성을 생략하는 필드이름과 동일한id의 bean을 찾음

	//Setter 기반 DI
	//setter의 매개변수 타입을기준으로 bean을 선택
	//required는 의존 객체를 주입하지 않아도 될 때 사용 required=false 로 설정하면 bean이 없어도 오류가 나지 않는다
	@Autowired(required=true)
	public void setNameService(INameInterface nameService) {
		this.nameService = nameService;
	}
	
	public void show(String name) {
		System.out.println("NameController : "  + nameService.showName(name));
	}
}
