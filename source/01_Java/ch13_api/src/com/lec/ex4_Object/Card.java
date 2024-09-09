package com.lec.ex4_Object;

public class Card {
	private String kind;
	private int num;
	public Card(String kind, int num) {
		super();
		this.kind = kind;
		this.num = num;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Card) {
			Card cardobj = (Card)obj;
			if(this.kind.equals(cardobj.kind) && this.num == cardobj.num) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "카드는 " + kind + "의 " + num + "입니다.";
	}
}
