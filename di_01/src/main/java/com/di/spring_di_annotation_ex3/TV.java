package com.di.spring_di_annotation_ex3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Speaker객체 필요 : DI(생성자)
@Component
public class TV {
	
	@Autowired
	private Speaker speaker;
	

	public void volumeUp() {
		speaker.volumeUp();
	}
	
	public void volumeDown() {
		speaker.volumeDown();
	}
}
