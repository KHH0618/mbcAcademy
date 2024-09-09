package com.lec.ex6_wrapper;

public class Ex02_parseInt {
	public static void main(String[] args) {
		System.out.println("문자열을 정수로 바꾸는 함수 : Integer.parseInt(문자열)");
		int i = Integer.parseInt("10");
		int j = 10;
		System.out.println(i);
		System.out.println("정수를 문자열로 바꾸는 함수 : String.valueOf(정수)");
		String str = String.valueOf(j);
		System.out.println(j);
	}
}
