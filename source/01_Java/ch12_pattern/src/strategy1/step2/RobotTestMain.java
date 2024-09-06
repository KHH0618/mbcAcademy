package strategy1.step2;

public class RobotTestMain {
	public static void main(String[] args) {
		Robot[] robots = {new SuperRobot(), new StandardRobot(), new LowRobot()};
		for (Robot robot : robots) {
			robot.shape();
			robot.actionWalk();
			robot.actionRun();
			if(robot instanceof SuperRobot) {
				SuperRobot temp = (SuperRobot)robot;
				temp.actionFly();
				temp.actionMissile();
				temp.actionKnife();				
			}else if (robot instanceof StandardRobot) {
				StandardRobot temp = (StandardRobot)robot;
				temp.actionFly();
				temp.actionMissile();
				temp.actionKnife();				
			}else if (robot instanceof LowRobot) {
				LowRobot temp = (LowRobot)robot;
				temp.actionFly();
				temp.actionMissile();
				temp.actionKnife();
				
			}
		}		
	}
}
