package com.lec.conditionQuiz;
//수를 입력받아 절대값을 출력하는 프로그램
import java.util.Scanner;
public class Quiz01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("정수를 입력하세요");
		int userInput = scanner.nextInt();
		if (userInput<0) {
			System.out.println(userInput * -1);
		}else {
			System.out.println(userInput);
		}
		scanner.close();
	}
}
