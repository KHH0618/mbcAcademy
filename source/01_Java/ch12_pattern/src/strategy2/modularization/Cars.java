package strategy2.modularization;

import strategy2.interfaces.EngineImpl;
import strategy2.interfaces.FuelEfficiencyImpl;
import strategy2.interfaces.FuelImpl;

public abstract class Cars {
	private EngineImpl engine;
	private FuelImpl fuel;
	private FuelEfficiencyImpl fE;
	
	public abstract void shape();
	String carname = getClass().getName();
	int idx = carname.lastIndexOf(".");
	String name = carname.substring(idx+1);
	public void print() {
		System.out.println(name+"차 : "+ engine.engine()+", 연비 : "+fE.fuelEfficiency()+" ("+fuel.fuel()+")");
	}
	public void drive() {
		System.out.println(name+" 가 움직입니다 부릉부릉~~");
	}
	
	//setter
	public void setEngine(EngineImpl engine) {
		this.engine = engine;
	}
	public void setFuel(FuelImpl fuel) {
		this.fuel = fuel;
	}
	public void setfE(FuelEfficiencyImpl fE) {
		this.fE = fE;
	}
}
