package com.lec.loopQuiz;

import java.util.Scanner;

//(while문): 컴퓨터와 가위바위보 게임을 -1을 입력할때까지 무한반복하는 게임을 작성하시오.(단, 가위대신 0, 바위대신 1, 보대신 2, 종료를 원하면 -1을 입력합니다)
public class Quiz01_while_rcp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input = 0;
		while (input != -1) {
			System.out.print("가위 바위 보를 입력하세요\n(단, 가위대신 0, 바위대신 1, 보대신 2, 종료를 원하면 -1을 입력합니다) >\t");
			input = scanner.nextInt();
			if (input == 0) {
				System.out.println("당신은 가위");
			} else if (input == 1) {
				System.out.println("당신은 바위");
			} else if (input == 2) {
				System.out.println("당신은 보!");
			} else {
				System.out.println("0,1,2 중에 입력해주셔야 합니다.");
			}
		}
		System.out.println("종료되었습니다");
		scanner.close();
	}
}
