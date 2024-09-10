package com.lec.ex3_excptions;

import java.util.Date;

public class Ex02FriendMain {
	public static void main(String[] args) {
		Friend f1 = new Friend("홍길동","010-9999-9999",new Date(98, 8, 10));
		System.out.println(f1);
		Friend f2 = new Friend("홍길동","010-9999-9999");
		System.out.println(f2);
		Friend f3 = new Friend("홍길동");
		System.out.println(f3);
		Friend f4 = new Friend("홍길동","010-9999-9999",new Date(98, 11, 20));
		System.out.println(f4);
		
	}
}