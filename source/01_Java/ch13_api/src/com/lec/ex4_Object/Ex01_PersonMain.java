package com.lec.ex4_Object;

public class Ex01_PersonMain {
	public static void main(String[] args) {
		Person p1 = new Person(1355433122025L);
		Person p2 = new Person(1355433122025L);
		Person p3 = null;
		String name = "홍길동";
		System.out.println(p1==p2);
		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p3));
		System.out.println(p1.equals(name));
		System.out.println(p1);
		System.out.println(p2);
	}
}
