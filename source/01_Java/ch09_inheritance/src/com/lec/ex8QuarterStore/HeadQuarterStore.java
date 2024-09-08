package com.lec.ex8QuarterStore;

public class HeadQuarterStore {
	private String storeName;

	public HeadQuarterStore(String storeName) {
		super();
		this.storeName = storeName;
	}
	public void kimchi() {
		System.out.println("김치찌개 : 8000");
	}
	public void bude() {
		System.out.println("부대찌개 : 8000");
	}
	public void bibim() {
		System.out.println("비빔밥 : 9000");
	}
	public void sunde() {
		System.out.println("순대국 : 8000");
	}
	public void gongi() {
		System.out.println("공기밥 : 1000");
	}
	@Override
	public String toString() {
		return "★" + storeName + "★";
	}
	
	public String getStoreName() {
		return storeName;
	}
}