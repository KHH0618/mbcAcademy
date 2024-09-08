package com.lec.ch07.ex2Rect;

public class RectMain {
	public static void main(String[] args) {
		Rect r1 = new Rect();
		Rect r2 = new Rect(3);
		Rect r3 = new Rect(2,4);
		
		r1.setHeight(3);
		r1.setWidth(7);
		System.out.printf("width %d * height %d = %d \n",r1.getWidth(),r1.getHeight(),r1.area());
		
		System.out.printf("width %d * height %d = %d \n",r2.getWidth(),r2.getHeight(),r2.area());
		
		System.out.printf("width %d * height %d = %d \n",r3.getWidth(),r3.getHeight(),r3.area());
	}
}
