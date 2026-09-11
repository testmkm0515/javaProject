package com.spring_mvc.projectData;

public class Student {
	//command 객체로 사용 -> 필드명을 파라미터명과 동일하게 설정
	private String no;
	private String name;
	private int year;
	
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

}
