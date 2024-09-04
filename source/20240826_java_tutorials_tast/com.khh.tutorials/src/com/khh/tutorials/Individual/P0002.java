package com.khh.tutorials.Individual;
//그러면 1부터 100까지 자연수에 대해 "합의 제곱"과 "제곱의 합"의 차이는 얼마입니까?
public class P0002 {
	public static void main(String[] args) {
		int sum = 0;
		int square = 0;
		for(int i = 1; i <= 100; i++) {
			sum += i;
			square += i*i;
		}
		sum = sum*sum;
		System.out.println(sum - square);
	}
}
