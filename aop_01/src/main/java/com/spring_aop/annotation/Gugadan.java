package com.spring_aop.annotation;

//핵심기능
public class Gugadan {
	private int dan;
	
	public int getDan() {
		return dan;
	}
	
	public void setDan(int dan) {
		this.dan = dan;
	}
	
	public void showResult() {
		for(int i=1; i<=9 ; i++) {
			System.out.println(dan + "*" + i + "=" + (dan*i));
		}
	}
}
