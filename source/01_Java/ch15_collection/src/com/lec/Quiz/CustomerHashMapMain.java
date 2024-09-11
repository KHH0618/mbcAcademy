package com.lec.Quiz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class CustomerHashMapMain {

	public static void main(String[] args) {
		String tel;
		Scanner scanner = new Scanner(System.in);
		HashMap<String, Object> customers = new HashMap<String, Object>();
		
		do {
			System.out.println("회원가입 하시겠습니까? Y or N");
			String yesOrNo = scanner.next();
			if(yesOrNo.toUpperCase().equals("Y")) {
				Customer customer = new Customer();
				System.out.println("성함을 입력하세요");
				customer.setName(scanner.next());
				System.out.println("전화번호를 입력하세요");
				tel = scanner.next();
				customer.setTel(tel);
				scanner.nextLine();
				System.out.println("주소를 입력하세요");
				customer.setAddress(scanner.nextLine());
				customers.put(tel,customer);
			}else if (yesOrNo.toUpperCase().equals("N")) {
				break;
			}else {
				System.out.println("Y or N으로 입력해 주세요");
			}
			
		}while(true);
		
		if(customers.size()>0) {
			Iterator<String> iterator = customers.keySet().iterator();
			while(iterator.hasNext()) {
				String key = iterator.next();
				System.out.println(customers.get(key));
			}
		}else if (customers.size() <= 0) {
			System.out.println("가입한 회원 목록이 없습니다");
		}
		scanner.close();
	}

}
