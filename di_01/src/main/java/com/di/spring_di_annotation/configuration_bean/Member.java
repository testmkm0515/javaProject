package com.di.spring_di_annotation.configuration_bean;

import java.util.ArrayList;

public class Member {
	private BMI bmi;
	private String name;
	private int age;
	private float height;
	private float weight;
	private ArrayList<String> courses;
	
	public BMI getBmi() {
		return bmi;
	}
	public void setBmi(BMI bmi) {
		this.bmi = bmi;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public ArrayList<String> getCourses() {
		return courses;
	}
	public void setCourses(ArrayList<String> courses) {
		this.courses = courses;
	}	
	
	public String toString() {
		return String.format("이름 : %s, 나이 : %s세, 키: %fcm, 몸무게:%fkg, 과정:%s ", this.name, this.age, this.height, this.weight, this.courses);
	}
	
}
















