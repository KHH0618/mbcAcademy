package strategy2.modularization;

import strategy2.interfaces.FuelHybrid;
import strategy2.interfaces.Km20;

public class TestMain {

	public static void main(String[] args) {
		
		Genesis genesis = new Genesis();
		Sonata sonata = new Sonata();
		Casper Casper = new Casper();
		
		Cars[] cars = {genesis, sonata, Casper};
		for (Cars car : cars) {
			car.drive();
			car.print();
			car.shape();
			System.out.println("--------------------------");
		}

		sonata.setFuel(new FuelHybrid());
		sonata.setfE(new Km20());
		for (Cars car : cars) {
			car.drive();
			car.print();
			car.shape();
			System.out.println("--------------------------");
		}
	}

}
