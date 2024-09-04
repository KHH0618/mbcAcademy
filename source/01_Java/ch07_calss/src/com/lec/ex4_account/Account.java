package com.lec.ex4_account;
//데이터(인스턴스변수) : accountNo(String), ownerName(String), balance(long)
//생성자 new Account("010-777-77", "홍길동"),new Account("010-777-77", "홍길동",10000)
//기능(메소드) : deposit(예금), withdraw(인출), infoPrint(정보출력), infoString(정보 문자로 반환)

public class Account {
	private String accountNo;
	private String ownerName;
	private long balance;
	
	//생성자
	public Account() {}
	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
	}
	public Account(String accountNo, String ownerName, long balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	
	//method
	//입금
	public void deposite(long money) {
		balance += money;
		System.out.println(money + "원을 입금했습니다. 현재 잔액은 "+ balance + "원 입니다.");
	}
	
	//출금
	public void withdraw(long money) {
		if(money<=balance) {
			balance -= money;
			System.out.println(money + "원이 출금되었습니다. 현재 잔액은 "+balance+"원 입니다.");
		}else {
			System.out.println("인출불가 잔액부족 입니다.");
			//ch14에서는 강제 예외 발생
		}
	}
	
	//계좌번호, 예금주 이름, 잔액 출력
	public void infoPrint() {
		System.out.printf("%s \"%s\"님 잔액 : %d원 입니다.\n",accountNo,ownerName,balance);
	}
	
	//계좌번호, 예금주 이름, 잔액 String으로 반환
	public String infoString() {
		String info = String.format("%s \"%s\"님 잔액 : %d원 입니다.",accountNo,ownerName,balance);
		return info;
	}
	
	
	//setter & getter
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public long getBalance() {
		return balance;
	}
}
