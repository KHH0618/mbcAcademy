package com.lec.ex3_math;

import java.util.Random;

// 0<= math.random <1
// 0 <= math.random*10 < 10
public class Ex02_random {
	public static void main(String[] args) {
		System.out.println("0 ~ 9 사이의 정수 난수 : "+ (int)(Math.random()*10));
		Random random = new Random();
		System.out.println("0 ~ 9 사이의 정수 난수 : "+ random.nextInt(10));
		System.out.println("true/false 난수 : " + random.nextBoolean());
		System.out.println("0,1,2 중 난수 : " + random.nextInt(3));
		
	}
}
