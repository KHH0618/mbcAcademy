package com.lec.loop;

//1~10까지 누적합을 출력
public class Ex08while {
	public static void main(String[] args) {

		int i = 1;
		int sum = 0;
		while (i <= 10) {
			sum += i;
			System.out.printf("i가 %d일때까지의 누적합은 %d\n", i, sum);
			i++;
		}
		System.out.println(sum);
	}
}
