package com.lec.ex2QuarterStore;

public class Store3 implements HeadQuarterStore {
	private String name;
	
	public Store3(String name) {
		this.name = name;
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
	@Override
	public void gongi() {
		System.out.println("공기밥 : 1000");
	}
	public String toString() {
		return "=="+name+"==";
	}
}
