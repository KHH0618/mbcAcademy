package strategy1.step5.modularization.copy;

import strategy1.step4.interfaces.*;

public class RobotTestMain {
	public static void main(String[] args) {
		SuperRobot superRobot = new SuperRobot();
		StandardRobot standardRobot = new StandardRobot();
		LowRobot lowRobot = new LowRobot();
		superRobot.setFly(new FlyHigh());
		lowRobot.setKnife(new KnifeToy());
		
		Robot[] robots = {superRobot, standardRobot, lowRobot};
		for (Robot robot : robots) {
			robot.shape();
			robot.actionWalk();
			robot.actionRun();
			robot.actionFly();
			robot.actionMissile();
			robot.actionKnife();
		}
		
	}
}
