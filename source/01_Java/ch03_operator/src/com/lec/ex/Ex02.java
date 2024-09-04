package com.lec.ex;
//증감연산자 : ++(1증가), --(1감소)
public class Ex02 {
	public static void main(String[] args) {
		int n1 = 10;
		//n1++;
		int n2 = ++n1;
		System.out.println(n1 + " " +" " + n2);
		n1 = 10;
		n2 = n1++;
		System.out.println(n1 + " " +" " + n2);
		n1 = 10;
		n2 = n1--;
		System.out.println(n1 + " " +" " + n2);
	}
}
