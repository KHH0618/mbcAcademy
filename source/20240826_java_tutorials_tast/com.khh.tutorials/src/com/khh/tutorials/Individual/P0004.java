package com.khh.tutorials.Individual;
//어떤 정수 n에서 시작해, n이 짝수면 2로 나누고, 홀수면 3을 곱한 다음 1을 더한다. 이렇게 해서 새로 만들어진 숫자를 n으로 놓고, n=1 이 될때까지 같은 작업을 계속 반복한다.
public class P0004 {
	public static void main(String[] args) {
		int i=7;
		boolean a = true;
		while (a) {
			if (i == 1) {
				a = false;
				System.out.println(i);
			}else if (i%2 == 0) {
				i = i/2;
				System.out.println(i);
			}else if (i%2 != 0) {
				i = i * 3 + 1;
				System.out.println(i);
			}
		}
	}
}