package strategy1.step5.modularization.copy;

import strategy1.step4.interfaces.FlyImpl;
import strategy1.step4.interfaces.KnifeImpl;
import strategy1.step4.interfaces.MissileImpl;

public abstract class Robot {
	private FlyImpl fly;
	private KnifeImpl knife;
	private MissileImpl missile;
	public abstract void shape();
	public void actionWalk() {
		System.out.println("걸을 수 있습니다.");
	}
	public void actionRun() {
		System.out.println("뛸 수 있습니다.");
	}
	
	public void actionFly() {
		fly.fiy();
	}
	
	public void actionMissile() {
		missile.missile();
	}
	
	public void actionKnife() {
		knife.knife();
	}

	//setter & getter
	public void setFly(FlyImpl fly) {
		this.fly = fly;
	}

	public void setMissile(MissileImpl missile) {
		this.missile = missile;
	}

	public void setKnife(KnifeImpl kneife) {
		this.knife = kneife;
	}
}
