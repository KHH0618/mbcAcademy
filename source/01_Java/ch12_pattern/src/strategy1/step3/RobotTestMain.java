package strategy1.step3;

public class RobotTestMain {
	public static void main(String[] args) {
		Robot[] robots = {new SuperRobot(), new StandardRobot(), new LowRobot()};
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
