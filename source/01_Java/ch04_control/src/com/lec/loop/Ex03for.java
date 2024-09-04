package com.lec.loop;

public class Ex03for {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 15; i <= 50; ++i) {
			String sumStr = (i == 50) ? (" = ") : (" + ");
			if (i % 5 == 4) {
				System.out.println(i + sumStr);
			} else {
				System.out.print(i + sumStr);
			}
			sum += i;
		}
		System.out.println(sum);
	}
}
