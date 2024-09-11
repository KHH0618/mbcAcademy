package com.lec.Quiz;

public class Customer {
	private String name;
	private String tel;
	private String address;

	public Customer() {
		super();
	}
	public Customer(String name, String tel, String address) {
		super();
		this.name = name;
		this.tel = tel;
		this.address = address;
	}
	
	
	
	@Override
	public String toString() {
		return "[이름] = " + name + ", [전화번호] = " + tel + ", [주소] = " + address;
	}


	//setter & getter
	public void setName(String name) {
		this.name = name;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
	public String getAddress() {
		return address;
	}
}
