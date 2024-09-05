package com.lec.ex1;

public class ClassEx implements InterfaceEx1, InterfaceEx2 {
	@Override
	public String method2() {
		System.out.println("2. 실제 구현은 implements한 클래스에서 해요");
		return null;
	}
	
	@Override
	public void method1() {
		System.out.println("1. 실제 구현은 implements한 클래스에서 해요");
	}
}
