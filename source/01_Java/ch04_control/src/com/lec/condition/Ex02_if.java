package com.lec.condition;
//사용자로부터 두 수를 입력받아, 두수를 비교하여 큰수와 작은수의 차를 구하시오
import java.util.Scanner;
public class Ex02_if {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a,b;
		System.out.println("첫번째 정수를 입력하세요");
		a = scanner.nextInt();
		System.out.println("두번째 정수를 입력하세요");
		b = scanner.nextInt();
		if(a>b) {
			System.out.printf("큰 수 %d, 작은 수 %d, 두수의 차는 %d",a,b,a-b);
		}else if (a<b) {
			System.out.printf("큰 수 %d, 작은 수 %d, 두수의 차는 %d",b,a,b-a);
		}else {
			System.out.println("두 수는 같습니다 두 수의 차는 0");
		}//if
		scanner.close();
	}//main
}//class
