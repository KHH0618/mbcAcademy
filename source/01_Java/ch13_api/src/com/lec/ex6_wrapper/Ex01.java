package com.lec.ex6_wrapper;

import com.lec.ex4_Object.Person;

//Wrapper 클래스
public class Ex01 {
	public static void main(String[] args) {
		String name = "홍길동";
		String otherName = "홍길동";
		System.out.println(name.equals(otherName));
		Person P = new Person(132154561321L);
		System.out.println(name.equals(10)); 
//		System.out.println(name.equals(new Integer(10))); ↑
		System.out.println(name.equals(10.9)); 
//		System.out.println(name.equals(new Double(10.9)));↑
	}
}
