package com.lec.ex;
//삼항 연산자 (조건식)?(조건이 true일 경우 취할 값):(조건이 false일 경우 취할 값);
public class Ex05 {
	public static void main(String[] args) {
		int h = 100;
		String result;
//		if(h%2 == 0) {
//			result = "짝수입니다.";
//		}else {
//			result = "홀수입니다.";
//		}
		result = (h%2 == 0)?("짝수입니다."):("홀수입니다.");
		System.out.println(result);
	}
}
