package com.lec.ex;

//x부터 y까지 정수 합과 그 결과가 짝/홀수인지 출력
public class Ex02method {
	public static void main(String[] args) {
		int tot = sum(10, 100);
		System.out.println("10부터 100까지 합은 " + tot + "입니다.");
		System.out.println(evenOdd(tot));
		tot = sum(1, 10);
		System.out.println("1부터 10까지 합은 " + tot + "입니다.");
		System.out.println(evenOdd(tot));
		tot = sum(5, 10);
		System.out.println("5부터 10까지 합은 " + tot + "입니다.");
		System.out.println(evenOdd(tot));
	}

	private static int sum(int from, int to) { // form부터 to까지 누적합 return
		int result = 0; // 누적변수
		for (int i = from; i <= to; i++) {
			result += i;
		}
		return result;
	}

	private static String evenOdd(int value) { // value가 짝 / 홀수인지를 retrun
		String result = (value % 2 == 0) ? "짝수입니다" : "홀수입니다";
//		if (value % 2 == 0) {
//			result = "짝수 입니다.";
//		}else {
//			result = "홀수 입니다";
//		}
		return result;
	}
}