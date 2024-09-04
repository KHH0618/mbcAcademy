package com.lec.ex04_override;
//mathod1(),mathod2()
public class Child extends Parent {
	//생성자 overloading = 함수의 중복정의
	public Child () {
		System.out.println("매개변수 없는 child생성자");		
	}
	public Child (int i) {
		System.out.println("매개변수 있는 child생성자");
	}
	
	@Override
	//override = 함수의 재정의
	public void method1() {
		System.out.println("child의 mathod1");
	}
	public void method3() {
		System.out.println("child의 mathod3");		
	}
	
	@Override
	public boolean equals(Object obj) {
		return true;
	}
}
