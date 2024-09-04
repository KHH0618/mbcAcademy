package com.lec.ex3_static;

public class Child {
	private String name;
	static Mom mom = new Mom();
	public Child (String name) {
		this.name = name;
	}
	
	public static void mathod() {
		System.out.println("mathod");
	}
	
	public void takeMoney(int money) {
		if(money <= mom.money) {
			mom.money -= money;
			System.out.println(name+"이/가"+money+"원을 엄마로 부터 받았습니다. 엄마 지갑에는"+ mom.money+"남았습니다.");
		}else {
			System.out.println(name+"이/가 돈 못받음. 현재 엄마 지갑엔"+mom.money);
		}
	}
}
