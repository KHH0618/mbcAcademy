package strategy2.modularization;

import strategy2.interfaces.*;

public class Casper extends Cars {
	public Casper() {
		setEngine(new EntryEngine());
		setfE(new Km20());
		setFuel(new Diesel());
	}
	@Override
	public void shape() {
		System.out.println("캐스퍼door, 캐스퍼 sheet, 캐스퍼 handle");

	}

}
