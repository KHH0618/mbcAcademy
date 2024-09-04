package com.lec.condition;
//점수 (0~100)을 입력받아 학점출력
import java.util.Scanner;
public class Ex04_swich_hakjum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("점수는?");
		int score = scanner.nextInt();
		int temp = score == 100 ? score-1 : score;
		switch(temp/10) {
		case 9 :
			System.out.println("A"); break;
		case 8 :
			System.out.println("B"); break;
		case 7 :
			System.out.println("C"); break;
		case 6 :
			System.out.println("D"); break;
		case 5 : case 4 : case 3 : case 2 : case 1 : case 0 :
			System.out.println("F"); break;
		default :
			System.out.println("유효하지 않은 점수입니다.");
		
		}
		scanner.close();
	}

}
