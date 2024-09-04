package com.lec.ex;

//return이 없는 메소드의 타입 void로
public class Ex04void {
	public static void main(String[] args) {
		printLine();
		System.out.println("Hello world");
		printLine('^',40);
		System.out.println("Hello java");
		printLine('=');
		System.out.println("Hello world");
		printLine(30);
	}

	public static void printLine() {
		for (int i = 0; i <= 20; i++) {
			System.out.print('-');
		}
		System.out.println();//개행
	}
	public static void printLine(char n, int j) {
		for (int i = 0; i <= j; i++) {
			System.out.print(n);
		}
		System.out.println();//개행
	}
	public static void printLine(int j) {
		for (int i = 0; i <= j; i++) {
			System.out.print('-');
		}
		System.out.println();//개행
	}
	public static void printLine(char n) {
		for (int i = 0; i <= 20; i++) {
			System.out.print(n);
		}
		System.out.println();//개행
	}
}
