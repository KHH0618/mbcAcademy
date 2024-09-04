package com.lec.method;
//sum(10,100), sum(10) - function over roding/evenOdd(10)/abs(-9)
public class Arithmetic {
	public  int sum(int from, int to) { // form부터 to까지 누적합 return
		int result = 0; // 누적변수
		for (int i = from; i <= to; i++) {
			result += i;
		}
		return result;
	}
	
	public int sum(int to) { // 1부터 to까지 누적합 return
		int result = 0; // 누적변수
		for (int i = 1; i <= to; i++) {
			result += i;
		}
		return result;
	}
	
	public String evenOdd(int value) { // value가 짝 / 홀수인지를 retrun
		String result = (value % 2 == 0) ? "짝수입니다" : "홀수입니다";
//		if (value % 2 == 0) {
//			result = "짝수 입니다.";
//		}else {
//			result = "홀수 입니다";
//		}
		return result;
	}
	
	public static int abs(int value) { //value의 절대값을 return
		return (value<=0)? -value : value ;
	}
}
