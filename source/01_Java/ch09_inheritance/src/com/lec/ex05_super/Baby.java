package com.lec.ex05_super;
//super() : 부모클래스의 생성자 함수
//super.~ : 부모클래스의
//private (name, character) public(intro(), setter & getter)
public class Baby extends Person {

	public Baby() {
//	super(); //부모클래스의 매개변수 없는 생성자 함수 호출. super 생략시 자동실행
		System.out.println("매개변수 없는 baby생성자");
	}
	public Baby(String name, String character) {
		super(name, character);//부모클래스의 매개변수 있는 생성자 함수. 반드시 첫번째 줄에 호출
		System.out.println("매개변수 있는 baby생성자");
//		setName(name);
//		setCharacter(character);
	}
	
	@Override
	public void intro() {
		System.out.print("♬ cry cry");
		super.intro();
	}
}
