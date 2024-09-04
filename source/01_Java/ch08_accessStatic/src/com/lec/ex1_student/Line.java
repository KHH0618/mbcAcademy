package com.lec.ex1_student;

public class Line {
	private String [] titles = {"이름","국어","영어","수학","총점","평균"};
	public void start() {
		System.out.println("\t\t\t   성적표");
		System.out.println("\t--------------------------------------------");
		for(String title : titles) {
			System.out.print("\t"+title);
		}
		System.out.println();
		System.out.println("\t--------------------------------------------");
	}
	
	public void line(String sign, int number) {
		for(int i = 0; i <= number; i++) {
			System.out.print(sign);
		}
		System.out.println();
	}
}
