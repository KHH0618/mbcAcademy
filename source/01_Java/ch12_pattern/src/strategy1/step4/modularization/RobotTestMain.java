package strategy1.step4.modularization;

import strategy1.step4.interfaces.FlyHigh;
import strategy1.step4.interfaces.KnifeToy;

public class RobotTestMain {
	public static void main(String[] args) {
		SuperRobot superRobot = new SuperRobot();
		StandardRobot StandardRobot = new StandardRobot();
		LowRobot LowRobot = new LowRobot();
		
		Robot[] robots = {new SuperRobot(), new StandardRobot(), new LowRobot()};
		superRobot.setFly(new FlyHigh());
		LowRobot.setKnife(new KnifeToy());
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
