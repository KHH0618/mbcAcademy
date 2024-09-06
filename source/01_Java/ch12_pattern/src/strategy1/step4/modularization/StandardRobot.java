package strategy1.step4.modularization;

import strategy1.step4.interfaces.FlyImpl;
import strategy1.step4.interfaces.FlyNo;
import strategy1.step4.interfaces.KnifeImpl;
import strategy1.step4.interfaces.MissileImpl;
import strategy1.step4.interfaces.MissileYes;
import strategy1.step4.interfaces.knifeWood;

public class StandardRobot extends Robot {
	private FlyImpl fly;
	private MissileImpl missile;
	private KnifeImpl kneife;
	public StandardRobot() {
		setFly(new FlyNo());
		setMissile(new MissileYes());
		setKneife(new knifeWood());
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
