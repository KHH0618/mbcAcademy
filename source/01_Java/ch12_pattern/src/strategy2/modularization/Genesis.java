package strategy2.modularization;

import strategy2.interfaces.Gasoline;
import strategy2.interfaces.HihgendEngine;
import strategy2.interfaces.Km10;

public class Genesis extends Cars {
	public Genesis() {
		setEngine(new HihgendEngine());
		setfE(new Km10());
		setFuel(new Gasoline());
	}
	
	@Override
	public void shape() {
		System.out.println("제내시스door, 제내시스 sheet, 제내시스 handel");
	}
}