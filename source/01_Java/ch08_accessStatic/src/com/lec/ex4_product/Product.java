package com.lec.ex4_product;

public class Product {
	private String modelNumber;// 모델명
	private int serialNumber;//객체 고유의 번호
	private static int count = 100; // static변수
	
	//생성자
	public Product() {}
	public Product(String modelNumber) {
		this.modelNumber = modelNumber;
		serialNumber = count++;
	}
	public void infoPrint() {
		System.out.println("모델명 : " + modelNumber + ", 시리얼 번호 : " + serialNumber);
	}
	
}
