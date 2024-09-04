package com.lec.loop;

//짝수를 입력 받아 출력
import java.util.Scanner;

public class Ex10doWhile {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input;
		do {
			System.out.print("짝수를 입력하세요 >\t");
			input = scanner.nextInt();
			if (input % 2 != 0 || input == 0) {
				System.out.println("짝수가 아닙니다");
			}
		} while (input % 2 != 0 || input == 0);
		System.out.printf("입력한 수(%d) 은/는 짝수입니다.", input);
		scanner.close();
	}

}
