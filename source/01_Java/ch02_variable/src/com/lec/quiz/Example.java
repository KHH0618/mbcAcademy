package com.lec.quiz;

public class Example {
	public static void main(String[] args) {
		double kr = 90.0, eg = 77.0, mt = 98.0;
		System.out.printf("국어 점수는 %.0f, 영어 점수는 %.0f, 수학 점수는 %.0f \n",kr,eg,mt);
		double sq = kr + eg + mt ;
		System.out.printf("총합은 %.0f \n",sq);
		double squ = (kr + eg + mt)/3;
		System.out.printf("평균은 %.2f",squ);
	}
}
