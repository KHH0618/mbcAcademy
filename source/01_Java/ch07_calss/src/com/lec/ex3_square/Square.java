package com.lec.ex3_square;

public class Square {
	private int side;

    // 생성자
	public Square() {
	System.out.println("매개변수 없는 생성자 호출");
	}
	public Square(int side) {
		this.side = side;
		System.out.println("매개변수 있는 생성자 호출");
	}
	
	//프로세스
	public int area() {
		return side * side;
	}
	
	//setter & getter
	public int getSide() {
		return side;
	}
	public void setSide(int side) {
		this.side = side;
	}
}
