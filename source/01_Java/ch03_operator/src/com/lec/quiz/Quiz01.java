package com.lec.quiz;
import java.util.Scanner;
public class Quiz01 {
	public static void main(String[] args) {
		Scanner userinput = new Scanner(System.in);
		System.out.println("정수를 입력하세요");
		int data = userinput.nextInt();
		if (data%2 == 0) {
		System.out.println("짝수입니다");
		}else if (data%3 == 0) {
			System.out.println("3의 배수입니다");
		}else {
			System.out.println("홀수입니다");
		} userinput.close();
	}
}
