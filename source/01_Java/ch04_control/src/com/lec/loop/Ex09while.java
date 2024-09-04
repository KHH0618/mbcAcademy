package com.lec.loop;

//1~100까지 숫자 중 3의 배수의 합을 출력
public class Ex09while {
	public static void main(String[] args) {
		int i = 1;
		int sum = 0;
		while (i <= 100) {

			if (i % 3 == 0) {
				sum += i;
			}
			i++;
//			i가 0일 경우에만
//			i++;
//			switch (i % 3) {
//			case 0: {
//				sum += i;
//				break;
//			}
//			default:
//				continue;
//			}
		}
		System.out.println(sum);
	}
}
