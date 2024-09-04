package com.lec.Quiz;

//사용자로부터 원하는 단수(2~9)를 입력받아 해당 구구단을 출력하는 프로그램을 구현하시오.
//(단, 단수를 매개변수로 받아 해당 단수의 구구단을 출력하는 부분을 method로 처리한다)
import java.util.Scanner;

public class Quiz01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("단수를 입력하세요");
		int dansu = scanner.nextInt();
		gugudan(dansu);
		scanner.close();
	}

	private static void gugudan(int dansu) {

		for (int i = 0; i <= 9; i++) {
			System.out.printf("%d X %d  = 0,\t", dansu, i, dansu * i);
		}
		System.out.println();
	}
}
