package com.lec.loopQuiz;

public class Quiz04_gugudan {
	public static void main(String[] args) {
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%d * %d = %2d\t", i, j, i * j);
			}
			System.out.println();
		}

		System.out.println(
				"--------------------------------------------------------------------------------------------------------");
		
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%d * %d = %2d\t", j, i, i * j);
			}
			System.out.println();
		}
	}
}
