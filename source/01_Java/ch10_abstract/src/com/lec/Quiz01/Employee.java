package com.lec.Quiz01;

public abstract class Employee {
	private double incentive = 0.;
	private String name;
	private int pay;
	private int hour;
	
	public Employee(String name,int pay) {
		super();
		this.name = name;
		this.pay = pay;
	}
	public Employee(String name,int pay, int hour) {
		super();
		this.name = name;
		this.pay = pay;
		this.hour = hour;
	}
	
	public abstract int computePay();
	
	public final double computeIncentive() {
		int p = pay/14;
		if(p>=3000000) {
			incentive = p*0.05;
		}
		
		return incentive;
	}

	public String getName() {
		return name;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public double getIncentive() {
		return incentive;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
