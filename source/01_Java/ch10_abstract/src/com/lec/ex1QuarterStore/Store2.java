package com.lec.ex1QuarterStore;

public class Store2 extends HeadQuarterStore {

	public Store2(String storeName) {
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
		System.out.println("비빔밥 : 8000");	
	}
	@Override
	public void sunde() {
		System.out.println("순대국 : 8000");
	}
	@Override
	public void gongi() {
		System.out.println("공기밥 : free");
	}
}
