package com.lec.Quiz01;

public class ChildTestMain {
	public static void main(String[] args) {
		Child child1 = new Child();
		child1.setI(1);
		child1.setJ(2);
		child1.sum();
		
		Child child2 = new Child(10,20);
		child2.sum();
	}
}
