package com.lec.ex3_speakerTv;
//interface : (1) 작업명세서 역할 (2) 다형성 구현 (3) 기능을 부품화
//interface : static final 변수(상수)와 추상메소드 (예외  : default메소드, static 메소드)
//작업 명세서 역할
public interface IVolum {
	public void volumeUp();
	public void volumeUp(int i);
	public void volumeDown();
	public void volumeDown(int i);
	public default void setMute(boolean mute) {
		if (mute) {
			System.out.println("무음");
		}else {
			System.err.println("무음 해제");
		}
	}
	
	public static void changeBattery() {
		System.out.println("건전지를 교환합니다.");
	}
}
