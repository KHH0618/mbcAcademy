package com.lec.condition;
//입력받은 수가 홀수인지 짝수인지 출력(if,switch, 삼항연산자)
import java.util.Scanner;
public class Ex07 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		System.out.println("정수를 입력하세요");
		int userInt = scanner.nextInt();
		//삼항연산자
		String type = (userInt%2 == 0)?(type ="짝수입니다"):(type = "홀수입니다");
		System.out.println(type);
		
		//if
		String typeIf;
		if (userInt % 2 == 0) {
			typeIf ="짝수입니다";
		}else{
			typeIf = "홀수입니다";
		}
		System.out.println(typeIf);
		
		//switch
		String typeSw;
		switch (userInt % 2) {
			case 1: typeSw = "홀수입니다"; break;
			case 0: typeSw = "짝수입니다"; break;
			default : typeSw = "짝수입니다";
		}
		System.out.println(typeSw);
		
		scanner.close();
	}
}
