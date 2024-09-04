package com.lec.condition;
// 실행할 때 마다 컴퓨터가 난수(random) 점수를 발생하여 학점 출력
public class Ex06_swithc_randomHakjum {
	public static void main(String[] args) {		
		int score = (int)(Math.random()*51+50);
		System.out.println(score);
		switch(score/10) {
		case 10 : case 9 :
			System.out.println("A"); break;
		case 8 :
			System.out.println("B"); break;
		case 7 :
			System.out.println("C"); break;
		case 6 :
			System.out.println("D"); break;
		default :
			System.out.println("F");
		
		}
	}
}
