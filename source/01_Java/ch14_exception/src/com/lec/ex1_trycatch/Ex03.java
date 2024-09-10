package com.lec.ex1_trycatch;

import java.util.InputMismatchException;
import java.util.Scanner;

//첫번째 정수를 제대로 입력할 때 까지 입력받음, 두번째 정수를 제대로 입력하지 않으면 1로 처리하여 수행하도록
//첫번째 정수를 제대로 입력할 때까지 받음
//두번째 정수를 제대로 입력하지 않으면 1로 할당받고, 곱셈, 덧셈, 뺄셈을 출력
public class Ex03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i = 0;
		int j = 1;
		do {
			try {
				System.out.print("첫번째 정수는 : ");// InputMismatchException
				i = scanner.nextInt();
				break;
			}catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				scanner.nextLine();//버퍼 지우는 목적
			}
		}while(true);
		System.out.print("두번째 정수는 : ");// InputMismatchException
		try {
			j = scanner.nextInt();
			System.out.println("i/j = " + (i / j));// ArithmeticException
		}catch (InputMismatchException e) {
			System.out.println("두번째 정수를 제대로 입력하지 않아 기본값 1로 설정되었습니다.");
		}catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("i*j = " + (i * j));
		System.out.println("i+j = " + (i + j));
		System.out.println("i-j = " + (i - j));
		scanner.close();
	}
}
