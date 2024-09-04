package com.lec.ex03_abc;

public class ABCTestMain {
	public static void main(String[] args) {
		S sobj = new S();
		S aobj = new A();
		B bobj = new B();
		C cobj = new C();
		
		S[] arr = {sobj, aobj, bobj, cobj};
		
		for(S temp : arr) {
			System.out.println(temp.s);
		}
	}
}
