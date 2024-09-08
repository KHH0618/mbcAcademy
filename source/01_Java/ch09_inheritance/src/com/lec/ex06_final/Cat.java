package com.lec.ex06_final;
//final variable : 변수 수정 불가, final method : override불가, final class : 상속금지
public final class Cat extends Animal{
	@Override
	public void running() {
		speed += 30;
		System.out.println("고양이가 마구 뛰어요. 현재 속도 : "+speed);
	}
}
