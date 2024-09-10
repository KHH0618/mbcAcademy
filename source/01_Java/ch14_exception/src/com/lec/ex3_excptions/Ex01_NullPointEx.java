package com.lec.ex3_excptions;

public class Ex01_NullPointEx {
	public static void main(String[] args) {
		String greeting = "Hellow";
		System.out.println(greeting.substring(2));
		greeting = null;
		System.out.println(greeting.substring(2));
	}
	
}
