package com.lec.ex1QuarterStore;

public class Store1 extends HeadQuarterStore {

	public Store1(String storeName) {
		super(storeName);
	}
	
	
	@Override
	public void kimchi() {
		System.out.println("김치찌개 : 8000");
	}
	@Override
	public void bude() {
		System.out.println("부대찌개 : 8000");
	}
	@Override
	public void bibim() {
		System.out.println("비빔밥 : 9000");	
	}
	@Override
	public void sunde() {
		System.out.println("현 매장에서 순대국은 판매하지 않습니다.");
	}
	@Override
	public void gongi() {
		System.out.println("공기밥 : 1000");
	}
}
