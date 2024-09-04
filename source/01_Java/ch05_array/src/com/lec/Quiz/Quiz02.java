package com.lec.Quiz;

//배열에 담긴 값의 합계, 평균, 최대값, 최소값을 구하는 프로그램을 작성하시오.
public class Quiz02 {
	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50, 12, 13 };
		int sum = 0;
		int max = arr[0];
		int min = arr[0];

		for (int idx = 0; idx < arr.length; idx++) {
			if (arr[idx] < max) {
				max = arr[idx];
			} else if (arr[idx] > min) {
				min = arr[idx];
			}
			sum += arr[idx];
		}

		System.out.printf("프로그램 결과 :\n합  계 = %d\n평  균 = %.1f\n최대값 = %d\n최소값 = %d", sum, (double) sum / arr.length, max,
				min);
	}
}
