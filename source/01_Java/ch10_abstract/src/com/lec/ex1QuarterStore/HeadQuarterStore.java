package com.lec.ex1QuarterStore;

public abstract class HeadQuarterStore {
	private String storeName;

	public HeadQuarterStore(String storeName) {
		super();
		this.storeName = storeName;
	}
	public abstract void kimchi();
	public abstract void bude();
	public abstract void bibim();
	public abstract void sunde();
	public abstract void gongi();
	@Override
	public String toString() {
		return "★" + storeName + "★";
	}
	
	public String getStoreName() {
		return storeName;
	}
}