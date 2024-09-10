package com.lec.ex1_trycatch;

public class Ex04_finally {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 2 };
		for (int i = 0; i <= arr.length; i++) {
			try {
				System.out.println(arr[i]);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			} finally {
				System.out.println("try절 실행후에도, cahch절 실행후에도 실행되는 절");
			}
		}
	}
}
