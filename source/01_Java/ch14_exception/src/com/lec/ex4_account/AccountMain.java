package com.lec.ex4_account;

public class AccountMain {

	public static void main(String[] args) {
		Account hong = new Account("100-1", "홍길동");
		hong.deposite(100);
		hong.infoPrint();
		try {
			hong.withdraw(10000);			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(hong.infoString());
		
		Account hong1 = new Account("2222-07-3921", "홍길순", 2200000000L);
		try {
			hong1.withdraw(2000);			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(hong1.infoString());
	}

}
