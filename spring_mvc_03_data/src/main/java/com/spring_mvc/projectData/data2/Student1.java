package com.spring_mvc.projectData.data2;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Student1 {
	//command 객체로 사용 -> 필드명을 파라미터명과 동일하게 설정
	private String no;
	private String name;
	private int year;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday; //Date 타입에 대해서는 전달되는 파라미터와 포맷을 동일하게 구성해야 함(DateTimeFormat 어노테이션으로 설정)
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
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
