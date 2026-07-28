package extendsex.instarray;

import java.util.Scanner;

public class Person {
	static Scanner s = new Scanner(System.in);
	
	String name;
	int age, height, weight;
	
	public void input() {
		System.out.print("\n성명 입력 : ");
		this.name = s.next();
		System.out.print("\n나이 입력 : ");
		this.age = s.nextInt();
		System.out.print("\n키 입력(cm) : ");
		this.height = s.nextInt();
		System.out.print("\n몸무게 입력(Kg) : ");
		this.weight = s.nextInt();		
	}
	
	public void output() {
		System.out.print(name + " ");
		System.out.print(age + "살");
		System.out.print(height + "cm");
		System.out.print(weight + "Kg");
		System.out.println();
	}
	
}







