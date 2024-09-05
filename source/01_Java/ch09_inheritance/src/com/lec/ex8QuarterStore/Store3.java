package com.lec.ex8QuarterStore;

public class Store3 extends HeadQuarterStore {

	public Store3(String storeName) {
		super(storeName);
	}
	
	@Override
	public void kimchi() {
		System.out.println("김치찌개 : 9000");
	}
	
	@Override
	public void bude() {
		System.out.println("부대찌개 : 10000");
	}
	
	@Override
	public void bibim() {
		System.out.println("비빔밥 : 10000");
	}
	
	@Override
	public void sunde() {
		System.out.println("얼큰순대국 : 9000");
	}
}
