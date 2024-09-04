package com.lec.ex;

public class VarEx02 {
	public static void main(String[] args) {
		int i = 10 ;
		byte j = -127;
		double h = 10.15;
		boolean b = true;
		System.out.println("i=" + i + "\t j=" + j + "\t h=" + h);
		// %d(정수) %f(실수) %c(문자) %s(문자열) %b(boolean)
		System.out.printf("i=%d,\t j=%d,\t h=%.2f,\t b=%b\n", i, j, h, b);
		char c1 = 'A';
		char c2 = '홍';
		System.out.printf("c1=%c, \t c2=%c \n",c1,c2);
		System.out.printf("c1=%d, \t c2=%d \n",(int)c1,(int)c2);
		System.out.println("끝");
	}
}
