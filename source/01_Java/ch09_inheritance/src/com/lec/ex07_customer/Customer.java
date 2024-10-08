package com.lec.ex07_customer;

public class Customer extends Person {
	private String address;
	private int sum;//구매금액 누적
	private int point;//포인트(구매시 구매금액에 1%)
	private String date;//String을 다음주부터는 날짜형
	private boolean vip; //true면 vip고객, false면 일반고객
	
	@Override
	public String infoString() {
		String result = super.infoString()+"\t[포인트] : " + point+"\t[구매누적]"+sum;
		result += (vip) ? "VIP 고객이십니다":"";
		return result;
	}
	
	public Customer(String name, String tel, String address, String date) {
		super(name, tel);
		this.address = address;
		this.date = date;
		point = 1000;
		System.out.println(name+"님 가입 감사 포인트 무려 1000점 드렸습니다.");
	}
	
	public void buy(int price) {
		sum += price;// 구매금액 누적
		if(vip == false && sum>=Constants.VIPLIMIT) {
			vip = true;
			System.out.println(getName()+"님 VIP로 업그레이드 되셨습니다.");
		}
		int thisPoint = (int)(price * Constants.POINTRATE);//금번 포인트
		point += thisPoint;
		System.out.println(getName() + "님 감사합니다 구매액 : "+price);
		System.out.println("금번 포인트 : "+thisPoint);
		System.out.println("누적 포인트 : " + point);
		System.out.println("누적 금액 : " + sum);
	}
}
