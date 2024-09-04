package com.lec.ch07.ex1Car;

public class Car {
	private String color;
	private int cc;
	private int speed;

	// 생성자
	public Car() {
	}

	public Car(String color) {
		this.color = color;
	}

	public Car(String color, int cc) {
		this.color = color;
		this.cc = cc;
	}
	

	public void drive() {
		speed = 60;
		System.out.printf("%s 색 차. 드라이브중입니다 속도%d\n",color,speed);
	}

	public void park() {
		speed = 0;
		System.out.printf("%s 색 차. 주차중입니다 속도%d\n",color,speed);
	}

	public void race() {
		speed = 120;
		System.out.printf("%s 색 차. 경주중입니다 속도%d\n",color,speed);
	}
	
	public void info() {
		System.out.printf("이 차량의 색은 %s 이며 배기량은 %d 입니다",color,cc);
	}

	
	// setter & getter
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
