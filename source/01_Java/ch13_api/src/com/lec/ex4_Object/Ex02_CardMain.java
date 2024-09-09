package com.lec.ex4_Object;

public class Ex02_CardMain {
	public static void main(String[] args) {
		Card card1 = new Card("다이아", 7);
		Card card2 = new Card("다이아", 7);
		System.out.println(card1.equals(card2));
		System.out.println(card1);
		System.out.println(card2);
	}
}
