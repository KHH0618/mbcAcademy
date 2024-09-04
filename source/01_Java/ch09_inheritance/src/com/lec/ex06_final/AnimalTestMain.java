package com.lec.ex06_final;

public class AnimalTestMain {
	public static void main(String[] args) {
		Animal[] animal = {new Animal(), new Dog(), new Cat()};
		for(Animal ani : animal) {
			ani.running();
			ani.running();
			ani.stop();
			System.out.println("--------------------------");
		}
	}
}
