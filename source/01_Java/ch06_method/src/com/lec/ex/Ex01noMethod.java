package com.lec.ex;

public class Ex01noMethod {
	public static void main(String[] args) {
		
		int tot=0;
		for(int i=1; i<11; i++){
			tot += i;
		}
		System.out.println("1~10까지 정수합은 "+tot+"입니다");
		System.out.println((tot%2==0)? "짝수입니다":"홀수입니다");
		tot=0;
		for(int i=10; i<100; i++){
			tot += i;
		}
		System.out.println("10~100까지 정수합은 "+tot+"입니다");
		System.out.println((tot%2==0)? "짝수입니다":"홀수입니다");
		
		tot=0;
		for(int i=5; i<11; i++){
			tot += i;
		}
		System.out.println("5~10까지 정수합은 "+tot+"입니다");
		System.out.println((tot%2==0)? "짝수입니다":"홀수입니다");
	}

}
