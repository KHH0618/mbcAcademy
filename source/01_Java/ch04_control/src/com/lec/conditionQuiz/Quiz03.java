package com.lec.conditionQuiz;

//가위바위보 중 하나를 내고(scanner.nextInt()사용) 낸 것을 출력하세요. 단, 사용자는 가위를 내고자 할 때는 0을 입력하고 바위를 선택하고자 할 때는 1을 입력하고, 보를 선택하고자 할 때는 2를 입력하여 합니다.
import java.util.Scanner;

public class Quiz03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("가위 : 0, 바위 : 1, 보 : 2 3개중 하나를 골라 입력하세요 > ");
		int rcp = scanner.nextInt();
		String rcpOut;
		if (rcp == 0) {
			rcpOut = "가위";
		} else if (rcp == 1) {
			rcpOut = "바위";
		} else if (rcp == 2){
			rcpOut = "보";
		} else {
			rcpOut = "다시 입력 하세요";
		}
		System.out.println(rcpOut);
		scanner.close();
	}
}
