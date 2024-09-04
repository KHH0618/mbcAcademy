package com.lec.ex;

public class Ex02array {
	public static void main(String[] args) {
		int[] arr = {0,0,0};
		// 확장 for문
		for (int a : arr) {
			System.out.println(a);
		}
		
		//일반 for문을 이용한 배열값 변경
		for (int idx = 0;idx<arr.length; idx++) {
			arr[idx] = 99;
		}
		for(int a : arr) {
			System.out.println(a);
		}
		
		//확장 for문을 이용한 배엷값 변경은 무효
		for (int temp : arr) {
			temp = 55;
		}
		for (int a : arr) {
			System.out.println(a);
		}
	}
}
