package com.lec.ex8QuarterStore;

public class Store2 extends HeadQuarterStore {

	public Store2(String storeName) {
		super(storeName);
	}
	
	@Override
	public void bibim() {
		System.out.println("비빔밥 : 8000");
	}
	
	@Override
	public void gongi() {
		System.out.println("공기밥 : free");
	}
}
