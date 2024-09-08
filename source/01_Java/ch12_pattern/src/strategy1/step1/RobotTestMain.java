package strategy1.step1;

public class RobotTestMain {
	public static void main(String[] args) {
		SuperRobot superrobot = new SuperRobot();
		StandardRobot standardrobot = new StandardRobot();
		LowRobot lowrobot = new LowRobot();
		
		superrobot.shape();
		superrobot.actionWalk();
		superrobot.actionRun();
		superrobot.actionFly();
		superrobot.actionMissile();
		superrobot.actionKnife();
		
		standardrobot.shape();
		standardrobot.actionWalk();
		standardrobot.actionRun();
		standardrobot.actionFly();
		standardrobot.actionMissile();
		standardrobot.actionKnife();
		
		lowrobot.shape();
		lowrobot.actionWalk();
		lowrobot.actionRun();
		lowrobot.actionFly();
		lowrobot.actionMissile();
		lowrobot.actionKnife();
	}
}
