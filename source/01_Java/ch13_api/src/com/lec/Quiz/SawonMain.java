package com.lec.Quiz;

public class SawonMain {
	public static void main(String[] args) {
		Sawoon[] employee = {new Sawoon("a01", "홍길동", Sawoon.COMPUTER),
							 new Sawoon("a02", "박길동", Sawoon.PLAYING,2024,9,1),
							 new Sawoon("a03", "이길동", Sawoon.COMPUTER,2024,9,2),
		};
		
		for (Sawoon temp : employee) {
			System.out.println(temp);
		}
	}
}
