package strategy1.step1;

public class LowRobot {
	public void shape() {
		System.out.println("Low Robot의 외형은 팔, 다리, 머리, 몸통이 있습니다 ==");
	}
	public void actionWalk() {
		System.out.println("걸을 수 있습니다.");
	}
	public void actionRun() {
		System.out.println("뛸 수 있습니다.");
	}
	public void actionFly() {
		System.out.println("날 수 없습니다.");
	}
	public void actionMissile() {
		System.out.println("미사일을 쏠 수 없습니다.");
	}
	public void actionKnife() {
		System.out.println("검 없습니다.");
	}
}
