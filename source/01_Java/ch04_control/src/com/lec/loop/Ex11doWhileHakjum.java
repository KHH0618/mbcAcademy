package com.lec.loop;

//점수 (0~100)을 입력받아 학점출력
import java.util.Scanner;

public class Ex11doWhileHakjum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int score;
		do {
			System.out.println("점수는?");
			score = scanner.nextInt();
			if (90 <= score && score <= 100) {
				System.out.println("A");
			} else if (80 <= score && score < 90) {
				System.out.println("B");
			} else if (70 <= score && score < 80) {
				System.out.println("C");
			} else if (60 <= score && score < 70) {
				System.out.println("D");
			} else if (0 <= score && score < 60) {
				System.out.println("F");
			} else {
				System.out.println("유효하지 않은 점수입니다");
			}
		} while (score < 0 || 100 < score);
		scanner.close();
	}

}
