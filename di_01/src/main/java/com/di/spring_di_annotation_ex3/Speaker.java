package com.di.spring_di_annotation_ex3;

import org.springframework.stereotype.Component;

@Component
public class Speaker {
	public void volumeUp() {
		System.out.println("볼륨 키웁니다");
	}
	
	public void volumeDown() {
		System.out.println("볼륨 줄입니다");
	}
}
