package strategy1.step4.modularization;

import strategy1.step4.interfaces.FlyHigh;
import strategy1.step4.interfaces.FlyImpl;

import strategy1.step4.interfaces.KnifeImpl;
import strategy1.step4.interfaces.KnifeYes;
import strategy1.step4.interfaces.MissileImpl;
import strategy1.step4.interfaces.MissileYes;

public class SuperRobot extends Robot {
	private FlyImpl fly;
	private MissileImpl missile;
	private KnifeImpl kneife;
	public SuperRobot() {
		setFly(new FlyHigh());
		setMissile(new MissileYes());
		setKneife(new KnifeYes());
	}
	
	@Override
	public void actionFly() {
		fly.fiy();
	}
	@Override
	public void actionMissile() {
		missile.missile();
	}
	@Override
	public void actionKnife() {
		kneife.knife();
	}

	//setter & getter
	public void setFly(FlyImpl fly) {
		this.fly = fly;
	}

	public void setMissile(MissileImpl missile) {
		this.missile = missile;
	}

	public void setKneife(KnifeImpl kneife) {
		this.kneife = kneife;
	}
}
