package com.lec.ex1_list;

import java.util.ArrayList;

public class Ex02_FriendArrayList {
	public static void main(String[] args) {
//		Friend[] fs = new Friend[2];
//		fs[0] = new Friend("홍길동", "010-9999-9999");
//		fs[1] = new Friend("신길동", "010-8888-8888");
		
		ArrayList<Friend> fsList = new ArrayList<Friend>();
		fsList.add(new Friend("홍길동","010-9999-9999"));
		fsList.add(new Friend("신길동", "010-8888-8888"));
		fsList.add(new Friend("구길동", "010-7777-7777"));
		
		for(int i = 0; i<fsList.size(); i++) {
			System.out.println(fsList.get(i));
		}
		
		System.out.println("---------------------------------------------");
		for(Friend fs : fsList) {
			System.out.println(fs);
		}
		System.out.println("---------------------------------------------");
		for(Friend fs : fsList) {
			System.out.println(fs.getName()+"\t"+fs.getTel());
		}
		
		System.out.println("---------------------------------------------");
		if(!fsList.isEmpty()) {
			for(int i = 0; i<fsList.size(); i++) {
				System.out.println(fsList.get(i).getName()+"\t"+fsList.get(i).getTel());
			}
		}else {
			System.out.println("Friend의 데이터가 없습니다.");
		}
	}
}
