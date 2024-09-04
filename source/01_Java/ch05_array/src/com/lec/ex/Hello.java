package com.lec.ex;
public class Hello {
	public static void main(String[] args) {
		System.out.println(args.length);
		System.out.println("Hello");
		for (int idx = 0; idx < args.length; idx++) {
			System.out.printf("Hello, %s\n", args[idx]);
		}
	}
}
