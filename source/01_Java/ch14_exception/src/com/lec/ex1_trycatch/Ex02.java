package com.lec.ex1_trycatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫번째 정수는 : ");
		int i = scanner.nextInt();
		System.out.print("두번째 정수는 : ");
		int j = scanner.nextInt();
		try {
			System.out.println("i/j = "+(i/j));//ArithmeticException			
		}catch (ArithmeticException e) {
			if(e.getMessage().equals("/ by zero")) {
				System.out.println("어떤 수를 0으로 나누면 1입니다.");				
			}
		}catch (InputMismatchException e) {
			System.out.println("혹시 소수를 입력하셨나요? 정수만 입력해주세요");
		}
		System.out.println("i*j = "+(i*j));
		System.out.println("i+j = "+(i+j));
		System.out.println("i-j = "+(i-j));
		scanner.close();
	}
}
