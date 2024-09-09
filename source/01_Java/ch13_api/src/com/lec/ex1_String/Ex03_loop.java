package com.lec.ex1_String;

import java.util.Scanner;

//I:입력로직, U:수정로직, X:종료
public class Ex03_loop {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String fn;
		do {
			System.out.println("I:입력, U : 수정, X : 종료");
			fn = scanner.next();
			switch (fn) {
			case "i": case "I" : {
				System.out.println("입력로직 수행");
				break;
			}
			case "u": case "U" : {
				System.out.println("수정로직 수행");
				break;
			}
		  }
		} while (!fn.equalsIgnoreCase("x"));
		scanner.close();
	}
}
