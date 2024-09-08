package com.lec.ch07.ex1Car;

public class CarMain {
	public static void main(String[] args) {
		Car car = new Car();
		
		car.setColor("gray");
		car.setCc(2500);
		
		car.park();
		car.drive();
		car.race();
		
		Car car2 = new Car("Red");
		car2.setCc(2600);
		car2.park();
		car2.drive();
		car2.race();
		
		Car car3 = new Car("blue", 2400);
		car3.park();
		car3.drive();
		car3.race();
	}
}
