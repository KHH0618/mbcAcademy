package com.lec.Quiz01;

public class SalaryEmployee extends Employee{

	public SalaryEmployee(String name, int pay) {
		super(name, pay);
	}
	@Override
	public int computePay() {
		return getPay()/14;
		
	}

}
