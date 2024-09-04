package com.lec.ex02_protected;
//private(i, j) / public setter&getter
//new Child() new Child(1,10)
public class Child extends SuperIJ{
	private int total;
	public Child() {
		System.out.println("매개변수 없는 child생성자");
	}
	public Child(int i, int j) {
		System.out.println("매개변수 있는 child생성자");
		this.i = i;
		this.j = j;
		
//		setI(i);
//		setJ(j);
	}
	
	public void sum() {
		total = i + j;
		System.out.println("i = "+ i +", j = "+ j +", total = "+ total);
		
//		total = getI()+getJ();
//		System.out.println(total);
	}
}
