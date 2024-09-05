package com.lec.Quiz01;

public class HourlyEmployee extends Employee {
	
	
	public HourlyEmployee(String name, int pay) {
		super(name, pay);
	}
	public HourlyEmployee(String name, int pay, int hour) {
		super(name, pay, hour);
	}
	

	@Override
	public int computePay() {
		return super.getHour() * super.getPay();
	}

}
