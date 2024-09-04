package com.lec.conditionQuiz;

//컴퓨터와 가위바위보 게임을 하는 프로그램을 구현하시오. 단, 사용자는 가위를 내고자 할 때는 0을 입력하고 바위를 선택하고자 할 때는 1을 입력하고, 보를 선택하고자 할 때는 2를 입력하여 게임을 진행합니다
import java.util.Scanner;

public class Quiz04 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String userin;//키보드로 입력받은것을 출력하기 위한 변수입니다.
		String cpuin;//컴퓨터가 어떤걸 냈는지 출력하기 위한 변수입니다.
		boolean outvalue = true;//키보드로 입력받는 과정에서 사용하기 위한 변수입니다.
		int userIn = 0; //맨 밑의 함수에서 사용하기 위한 변수입니다.

		//키보드로 부터 입력받아 가위 바위 보를 출력 다만 0,1,2 값이 아닌 다른값이 오면 다시 실행
		//제 방법대로 한번 해보았습니다. 수업진도와 다를수도있지만 논리적인 사고를 키워보고싶어서 작성하였습니다.
		while (outvalue) {
			System.out.print("가위 : 0, 바위 : 1, 보 : 2 3개중 하나를 골라 입력하세요 > ");
			int userinput = scanner.nextInt();
			if (userinput == 0) {
				userIn = 0;
				userin = "당신은 가위";
				System.out.println(userin);
				outvalue = false;//while문 을 탈출하기 위한 변수
			} else if (userinput == 1) {
				userIn = 1;
				userin = "당신은 바위";
				System.out.println(userin);
				outvalue = false;//while문 을 탈출하기 위한 변수
			} else if (userinput == 2) {
				userIn = 2;
				userin = "당신은 보";
				System.out.println(userin);
				outvalue = false;//while문 을 탈출하기 위한 변수
			} else {
				System.out.println("다시 입력하세요");
			}//if문 닫음
		}//while문 닫음

		scanner.close();
		
		// 컴퓨터에 가위 바위 보를 넣는 함수
		int cupinput = (int) (Math.random() * 3);
		if (cupinput == 0) {
			cpuin = "컴퓨터는 가위";
			System.out.println(cpuin);
		} else if (cupinput == 1) {
			cpuin = "컴퓨터는 바위";
			System.out.println(cpuin);
		} else if (cupinput == 2) {
			cpuin = "컴퓨터는 보";
			System.out.println(cpuin);
		}

		//키보드 입력값과 컴퓨터 난수값을 비교하여 출력하는 로직입니다.
		if (userIn == 0) {
			if (cupinput == 0) {
				System.out.println("비겼습니다");
			} else if (cupinput == 1) {
				System.out.println("졌습니다");
			} else {
				System.out.println("이겼습니다");
			}// 중첩 if 문 닫음
		} else if (userIn == 1) {
			if (cupinput == 0) {
				System.out.println("이겼습니다");
			} else if (cupinput == 1) {
				System.out.println("비겼습니다");
			} else {
				System.out.println("졌습니다");
			}// 중복 if 문 닫음
		} else if (userIn == 2) {
			if (cupinput == 0) {
				System.out.println("졌습니다");
			} else if (cupinput == 1) {
				System.out.println("이겼습니다");
			} else {
				System.out.println("비겼습니다");
			}// 중첩 if 문 닫음
		}// if문 닫음
	}// main 닫음
}
