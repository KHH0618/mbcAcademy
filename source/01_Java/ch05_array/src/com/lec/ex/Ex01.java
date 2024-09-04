package com.lec.ex;

public class Ex01 {
	public static void main(String[] args) {
		//int i = 10; 변수 선언과 초기화 한번에
		// 1. 배열 변수 선언과 초기화
		int[] iArr = { 10, 20, 30, 40, 50 };
		iArr[2] = 333;
		for (int idx = 0; idx < iArr.length; idx++) {
			System.out.println(idx + "번째는" + iArr[idx]);
		}

		// 2. 배열 변수 선언과 배열 메모리 공간 확보
		int[] iArr2 = new int[5];
		for (int idx = 0; idx < iArr2.length; idx++) {
			System.out.println(idx + "번째는" + iArr2[idx]);
		}
		// 3. 배열 변수 선언
		int [] arr;
		arr = new int[3];
		arr[0] = 3;
		for(int a : arr) {//확장 for문
			System.out.println(a);
		}
	}
}
