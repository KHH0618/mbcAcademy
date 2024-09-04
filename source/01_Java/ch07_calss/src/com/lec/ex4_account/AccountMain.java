package com.lec.ex4_account;

public class AccountMain {

	public static void main(String[] args) {
		Account hong = new Account("100-1", "홍길동");
		hong.deposite(100);
		hong.infoPrint();
		System.out.println(hong.infoString());
		
		Account hong1 = new Account("2222-07-3921", "홍길순", 2200000000L);
		hong1.withdraw(2000);
		System.out.println(hong1.infoString());
	}

}
