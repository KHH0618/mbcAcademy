package singleton2;

public class SecondClass {

	public SecondClass() {
		System.out.println("SecondClass 생성자 실행중 ---");
		SingletonClass secondSingletonObj = SingletonClass.getInstance();
		System.out.println("Singleton객체의 i값 " + secondSingletonObj.getI());
		secondSingletonObj.setI(50);
		System.out.println("Singleton객체의 수정후 i값 " + secondSingletonObj.getI());
	}
}
