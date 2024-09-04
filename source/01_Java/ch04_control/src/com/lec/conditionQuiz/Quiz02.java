package com.lec.conditionQuiz;
//두 수 중 큰 수를 변수 max에 입력하고 변수 max를 출력하는 프로그램입니다. 잘못된 부분은?
public class Quiz02 {
	public static void main(String[] args) {
		/*
		int num1 = 27;
		int num2 = 32;
		if(num1>num2){
			int max = num1;
		} else {
			int max = num2;
		}
		System.out.println(max);
		 */
		int max = 0;
		int num1 = 27;
		int num2 = 32;
		if(num1>num2){
			max = num1;
		} else if(num1<num2){
			max = num2;
		}else {
			System.out.println("두 수는 같습니다");
		}
		System.out.println(max);

	}
}
