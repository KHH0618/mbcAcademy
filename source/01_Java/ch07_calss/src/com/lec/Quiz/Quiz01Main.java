package com.lec.Quiz;

import java.util.Scanner;
public class Quiz01Main {
	public static void main(String[] args) {
		Quiz01Member member1 = new Quiz01Member("aaa", "xxx", "홍길동", "hong@company.com",
                "서울시 강남구", "2000-01-01", 'M');
		Quiz01Member member2 = new Quiz01Member("bbb", "xxx", "신길동", "shin@company.com", 
				"서울시 서대문구 신촌로 141", "1999-01-02", 'F');
		member1.print();
		member2.print();
		
//		심심해서 로그인 하는듯한 함수도 만들어 보았습니다.
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("아이디를 입력하세요");
//		String id = scanner.next();
//		System.out.println(id);
//		System.out.println("비밀번호를 입력하세요");
//		String pw = scanner.next();
//		member1.login(id, pw);
//		scanner.close();
	}

}
