package com.lec.ex5_Scanner;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("주소 : ");
//		scanner.nextLine();//버퍼에 남아있는 내용을(\n포함) 지우는 용도
		String address = scanner.nextLine(); // "\n"앞의 값을 return하고 나머지는 버퍼에서 지움
		System.out.println("입력한 주소 : " + address);
		System.out.print("나이 : ");
		int age = scanner.nextInt();
		System.out.println("입력한 나이 : " + age);
		System.out.print("이름 : ");
		String name = scanner.next();// white space(space, tap, \n)앞까지만 return하고 나머지는 버퍼에
		System.out.println("입력한 이름은 : " + name);
		scanner.close();
	}
}
