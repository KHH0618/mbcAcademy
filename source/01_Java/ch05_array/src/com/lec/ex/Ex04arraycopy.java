package com.lec.ex;

public class Ex04arraycopy {
	public static void main(String[] args) {
		int[] score = { 100, 20, 30, 40, 50 };
		int[] s = new int[score.length];

//		for (int idx = 0; idx < score.length; idx++) {
//			s[idx] = score[idx];
//		}

		System.arraycopy(score, 0, s, 0, score.length);

		for (int idx = 0; idx < score.length; idx++) {
			System.out.printf("score[%d]=%d \t s[%d]=%d\n", idx, score[idx], idx, s[idx]);
		} // s배열 변경 전

		s[0] = 99;// s배열 변경

		System.out.println("s배열 변경");

		for (int idx = 0; idx < score.length; idx++) {
			System.out.printf("score[%d]=%d \t s[%d]=%d\n", idx, score[idx], idx, s[idx]);
		} // s배열 변경 후
	}
}
