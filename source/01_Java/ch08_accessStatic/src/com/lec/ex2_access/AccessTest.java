package com.lec.ex2_access;

public class AccessTest {
	private int privateMemver; // 같은 클래스 내에서만 사용 가능
			int defaultMember; // 같은 패키지에서 만 사용 가능
	protected int protectedMember; // 같은 패키지나 상속받은 클래스에서만 사용 가능
	public int publicMember;// 아무데서나 사용 가능
	
	private void privateMethod() {
		System.out.println("privateMethod");
	}
	void defalutMethod() {
		System.out.println("defalutMethod");
	}
	protected void protectedMethod() {
		System.out.println("protectedMethod");
	}
	public void publicMethod() {
		System.out.println("publicMethod");
	}
}
