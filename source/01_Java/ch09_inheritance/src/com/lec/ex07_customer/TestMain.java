package com.lec.ex07_customer;

public class TestMain {
	public static void main(String[] args) {
		Customer customer = new Customer("홍길동", "010", "서울", "01-01");
		Staff staff = new Staff ("홍길순","010","운영지원부");
		customer.buy(500000);
		System.out.println("--------------------------");
		customer.buy(500000);
		System.out.println("--------------------------");
		
		Person[] person = {customer, staff};
		for (Person p : person) {
			System.out.println(p.infoString());
		}
	}
}
