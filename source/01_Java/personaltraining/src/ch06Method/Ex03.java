package ch06Method;

import arithmetic.Arithmetic;

public class Ex03 {
	public static void main(String[] args) {
		
		Arithmetic ar1 = new Arithmetic();
		ar1.setFrom(1);
		ar1.setTo(10);
		System.out.println(ar1.sum());
		System.out.println(ar1.envnOdd());	
		
		Arithmetic ar2 = new Arithmetic(1,100);
		System.out.println(ar2.sum());
		System.out.println(ar2.envnOdd());	
		
		Arithmetic ar3 = new Arithmetic(5,10);
		System.out.println(ar3.sum());
		System.out.println(ar3.envnOdd());	
	}
}
