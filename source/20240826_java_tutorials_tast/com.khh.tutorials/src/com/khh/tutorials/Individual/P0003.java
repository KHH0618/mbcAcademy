package com.khh.tutorials.Individual;
//1부터 20까지의 어떤 수로도 나누어 떨어지는 가장 작은 수는 얼마입니까?
public class P0003 {
	public static void main(String[] args) {
		int i = 0;
		boolean a = true;
		while (a) {
			i++;
			if(i%1 == 0&&i%2 == 0&&i%3 == 0&&i%4 == 0&&i%5 == 0&&i%6 == 0&&i%7 == 0&&i%8 == 0&&i%9 == 0&&i%10 == 0&&i%11 == 0&&i%12 == 0&&i%13 == 0&&i%14 == 0&&i%15 == 0&&i%16 == 0&&i%17 == 0&&
			   i%18 == 0&&i%19 == 0&&i%20 == 0) {
				a = false;
				System.out.println(i);
			}
		}
	}
}
