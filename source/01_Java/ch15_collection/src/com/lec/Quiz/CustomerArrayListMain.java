package com.lec.Quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerArrayListMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Customer> customers = new ArrayList<Customer>();
		String yesOrNo;
		String name;
		String tel;
		String address;
		
		do {
			System.out.println("회원가입 하시겠습니까? Y or N");
			yesOrNo = scanner.next();
			if(yesOrNo.toUpperCase().equals("Y")) {
				System.out.println("성함을 입력하세요");
				name = scanner.next();
				System.out.println("전화번호를 입력하세요");
				tel = scanner.next();
				address = scanner.nextLine();
				System.out.println("주소를 입력하세요");
				address = scanner.nextLine();
				customers.add(new Customer(name, tel, address));
			}else if (yesOrNo.toUpperCase().equals("N")) {
				break;
			}else {
				System.out.println("Y or N으로 입력해 주세요");
			}
			
		}while(true);
		
		for (Customer customer : customers) {
			System.out.println(customer);
		}
		scanner.close();
	}
}