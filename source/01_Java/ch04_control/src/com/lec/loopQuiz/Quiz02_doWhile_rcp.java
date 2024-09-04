package com.lec.loopQuiz;

import java.util.Scanner;

public class Quiz02_doWhile_rcp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int userin = 0;
		boolean userlose = true;
		do {
			do {
				System.out.print("가위 바위 보를 입력하세요\n(단, 가위대신 0, 바위대신 1, 보대신 2입력합니다) >\t");
				userin = scanner.nextInt();
				if (userin == 0) {
					System.out.println("당신은 가위");
				} else if (userin == 1) {
					System.out.println("당신은 바위");
				} else if (userin == 2) {
					System.out.println("당신은 보!");
				} else {
					System.out.println("0,1,2 중에 입력해주셔야 합니다.");
				}//키보드 입력값 닫기
			} while (userin < 0 || userin > 2); // 키보드 입력 후 종료

			int cpuin = (int) (Math.random() * 3);
			System.out.print("컴퓨터가 입력중입니다\t");
			System.out.println(cpuin);
			if (cpuin == 0) {
				System.out.println("컴퓨터는 가위");
			} else if (cpuin == 1) {
				System.out.println("컴퓨터는 바위");
			} else if (cpuin == 2) {
				System.out.println("컴퓨터는 보!");
			} // 컴퓨터 입력 종료

			if (userin == cpuin) {
				System.out.println("비겼습니다");
			} else if (userin - cpuin == 1 || userin - cpuin == -2) {
				System.out.println("이겼습니다");  userlose = false;
			} else if (userin - cpuin == 2 || userin - cpuin == -1) {
				System.out.println("졌습니다");
			}//가위 바위 보 결과값
		} while (userlose);
		scanner.close();
	}
}
