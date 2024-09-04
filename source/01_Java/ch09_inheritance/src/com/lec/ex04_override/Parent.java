package com.lec.ex04_override;

public class Parent {
	public Parent(){
		System.out.println("매개변수 없는 parent 생성자");
	}
	public Parent(int i){
		System.out.println("매개변수 있는 parent 생성자");
	}
	public void method1() {
		System.out.println("parent의 mathod1");
	}
	public void method2() {
		System.out.println("parent의 mathod2");
	}
}
