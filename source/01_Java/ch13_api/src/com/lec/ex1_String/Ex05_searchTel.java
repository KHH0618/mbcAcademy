package com.lec.ex1_String;
import java.util.Scanner;
//배열에 있는 전화번호 검색
public class Ex05_searchTel {
	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		String[] tels = {"010-1111-9999", "010-2222-8888", "02-555-9999"};
		boolean noSearch = true;//검색결과가 없다고 true. 검색결과가 있으면 false
		System.out.println("전화번호 뒷자리를 입력하세요");
		String searchTel = scanner.next();
		for (String tel : tels) {
			int telIdx = tel.lastIndexOf("-")+1;
			String postTel = tel.substring(telIdx);
			if (postTel.equals(searchTel)) {
				System.out.println("검색한 전화번호는 " + tel);
				noSearch = false;
			}
		}
		if(noSearch) {
			System.out.println("검색하신 전화번호가 존재하지 않습니다.");
		}
		scanner.close();
	}
}
