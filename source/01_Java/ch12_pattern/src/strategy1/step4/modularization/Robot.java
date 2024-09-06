package strategy1.step4.modularization;

public abstract class Robot {
	public void shape() {
		String classname = getClass().getName();//클래스 이름 
		int idx = classname.lastIndexOf(".");//맨 마지막"."의 위치
		String name = classname.substring(idx+1);
		System.out.println(name+"의 외형은 팔, 다리, 머리, 몸통이 있습니다 ==");
	}
	public void actionWalk() {
		System.out.println("걸을 수 있습니다.");
	}
	public void actionRun() {
		System.out.println("뛸 수 있습니다.");
	}
	
	public abstract void actionFly();
	public abstract void actionMissile();
	public abstract void actionKnife();
}
