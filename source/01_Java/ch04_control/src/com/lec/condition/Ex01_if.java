package com.lec.condition;
//조건문 : if문, switch문
public class Ex01_if {
	public static void main(String[] args) {
		int score = 65;
		if(score >= 90) {
			System.out.println("참 잘했어요");
		}else if(score >= 70) {
			System.out.println("조금 잘했어요");
		}else if(score >= 50) {
			System.out.println("조금 못했어요");
		}else {
			System.out.println("많이 못했어요");
		}
	}
}