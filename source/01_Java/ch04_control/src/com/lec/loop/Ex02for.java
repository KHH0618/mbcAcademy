package com.lec.loop;
// 1~10까지 누적합 출력
public class Ex02for {

	public static void main(String[] args) {
		int sum = 0;
		for(int i = 0; i<=100; i++) {
			String sumStr = (i == 100)? (" = "):(" + ");
			//System.out.print(sum+" + "+i+" =\t");
			System.out.print(i+sumStr);
			sum += i;
			//System.out.println(sum);
		}
		System.out.println(sum);
	}
}
