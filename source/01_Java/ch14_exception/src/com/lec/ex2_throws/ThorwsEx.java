package com.lec.ex2_throws;

public class ThorwsEx {
	public ThorwsEx() throws Exception {
		actionB();
	}

	private void actionB() throws ArrayIndexOutOfBoundsException {
		System.out.println("actionB 전반부");
		actionA();
//			e.printStackTrace(); 예외메세지를 더 자세하게

		System.out.println("actionB 후반부");
	}

	private void actionA() throws ArrayIndexOutOfBoundsException {
		System.out.println("actionA 전반부");
		int[] arr = { 0, 1, 2 };
		System.out.println(arr[3]);
		System.out.println("actionA 후반부");
	}
}
