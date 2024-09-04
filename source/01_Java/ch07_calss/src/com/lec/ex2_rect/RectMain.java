package com.lec.ex2_rect;

public class RectMain {

	public static void main(String[] args) {
		Rect r1 = new Rect();
		Rect r2 = new Rect(3);
		Rect r3 = new Rect(2,4);
		
		System.out.println(r1.area());
		System.out.println(r2.area());
		System.out.println(r3.area());

	}

}
