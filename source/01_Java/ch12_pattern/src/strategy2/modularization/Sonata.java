package strategy2.modularization;

import strategy2.interfaces.*;

public class Sonata extends Cars {
	public Sonata() {
		setEngine(new MiddleEngine());
		setfE(new Km15());
		setFuel(new Gasoline());
	}
	@Override
	public void shape() {
		System.out.println("소나타door, 소나타 sheet, 소나타 handel");
	}

}
