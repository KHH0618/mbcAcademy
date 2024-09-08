package com.lec.ex8QuarterStore;

public class Store1 extends HeadQuarterStore {

	public Store1(String storeName) {
		super(storeName);
	}
	
	@Override
	public void bude() {
		System.out.println("부대찌개 : 8000");
	}
	
	@Override
	public void sunde() {
		System.out.println("현 매장에서 순대국은 판매하지 않습니다.");
	}
}
