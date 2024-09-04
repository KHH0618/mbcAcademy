package com.lec.quiz;
import java.util.Scanner;
//국어, 영어, 수학 점수를 사용자에게 입력받아, 각 점수를 출력하고 총점, 평균(소수점2자리까지) 출력하는 프로그램을 구현 하시오
public class Quiz02 {
	public static void main(String[] args) {
		int kor, eng, mat;
		Scanner korinput = new Scanner(System.in),enginput = new Scanner(System.in),matinput = new Scanner(System.in);
		System.out.println("국어점수를 입력하세요");
		kor = korinput.nextInt();
		System.out.println("영어점수를 입력하세요");
		eng = enginput.nextInt();
		System.out.println("수학점수를 입력하세요");
		mat = matinput.nextInt();
		
		int result = kor+eng+mat;
		double resultDouble = (double) result / 3;
		System.out.println("3 과목의 합은"+result+"입니다");
		System.out.printf("3 과목의 평균은 %.2f입니다", resultDouble);
		korinput.close();
		enginput.close();
		matinput.close();
	}
}
