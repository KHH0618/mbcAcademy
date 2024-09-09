package com.lec.ex1_String;

import java.util.Scanner;
//quiz : 전화번호(010-123-456,02-9876-5432)입력받아, 전번, 짝수번째 문자, 거꾸로, 구건, 뒷 4자리 출력

public class Ex04_tel {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String tel;
		do {
			System.out.println("전화번호를 입력하세요. 종료하려면 X를 입력하세요");
			tel = scanner.next();

			if (tel.equalsIgnoreCase("x")) {
				break;
			}

			System.out.println("입력한 전화번호 : " + tel);
			System.out.print("짝수번째 문자열 : ");
			for (int i = 0; i < tel.length(); i++) {
				if (i % 2 == 0) {
					System.out.print(tel.charAt(i) + " ");
				}
			}
			System.out.println();
			System.out.print("거꾸로 출력 : ");
			for (int i = tel.length() - 1; i >= 0; i--) {
				System.out.print(tel.charAt(i));
			}
			System.out.println();
			int deshe = tel.indexOf("-");
			if (deshe != -1) {
				int lastdeshe = tel.lastIndexOf("-");
				System.out.println("지역번호 : " + tel.substring(0, deshe));
				System.out.println("뒷 4자리 : " + tel.substring(lastdeshe + 1));
			}
		} while (true);
		scanner.close();
		System.out.println("프로그램이 종료되었습니다.");
	}
}
