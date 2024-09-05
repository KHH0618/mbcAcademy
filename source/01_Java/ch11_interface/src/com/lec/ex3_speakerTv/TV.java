package com.lec.ex3_speakerTv;

public class TV implements IVolum {
	private int volumeLevel;
	private final int TV_MAX_VILUME = 50;
	private final int TV_MIN_VILUME = 0;

	public TV(int volumeLevel) {
		super();
		this.volumeLevel = volumeLevel;
	}

	@Override
	public void volumeUp() {
		
		if((volumeLevel+5) < TV_MAX_VILUME) {
			volumeLevel+=5;
			System.out.println("TV 볼륨을 5만큼 올려 현재"+volumeLevel);
		}else if(volumeLevel <= TV_MAX_VILUME) {
			int temp = TV_MAX_VILUME -volumeLevel;
			volumeLevel = TV_MAX_VILUME;
			System.out.println("TV 볼륨을" + temp + "올렸습니다.");
		}else {
			System.out.println("TV 볼륨이 최대치여서 올리지 못했습니다.");
		}

	}
	
	@Override
	public void volumeUp(int i) {
		if((volumeLevel+i) < TV_MAX_VILUME) {
			volumeLevel+=i;
			System.out.println("TV 볼륨을 "+i+"만큼 올려 현재"+volumeLevel);
		}else if(volumeLevel <= TV_MAX_VILUME) {
			int temp = TV_MAX_VILUME -volumeLevel;
			volumeLevel = TV_MAX_VILUME;
			System.out.println("TV 볼륨을" + temp + "올렸습니다. 현재"+volumeLevel);
		}else {
			System.out.println("TV 볼륨이 최대치여서 올리지 못했습니다.");
		}
	}

	@Override
	public void volumeDown() {
		if((volumeLevel-5) > TV_MIN_VILUME) {
			volumeLevel-=5;
			System.out.println("TV 볼륨을 5만큼 내려 현재 "+volumeLevel);
		}else if(volumeLevel > TV_MIN_VILUME){
			int temp = volumeLevel - TV_MIN_VILUME;
			volumeLevel = TV_MIN_VILUME;
			System.out.println("TV 볼륨을" + temp + "만큼 내렸습니다.");
		}else {
			System.out.println("TV 볼륨이 최소치여서 내리지 못했습니다.");
		}

	}
	
	@Override
	public void volumeDown(int i) {
		if((volumeLevel-i) > TV_MIN_VILUME) {
			volumeLevel-=i;
			System.out.println("TV 볼륨을 "+i+"만큼 내려 현재"+volumeLevel);
		}else if(volumeLevel > TV_MIN_VILUME){
			int temp = volumeLevel - TV_MIN_VILUME;
			volumeLevel = TV_MIN_VILUME;
			System.out.println("TV 볼륨을 " + temp + "만큼 내렸습니다. 현재 "+volumeLevel);
		}else {
			System.out.println("TV 볼륨이 최소치여서 내리지 못했습니다.");
		}
	}
	
	@Override
	public void setMute(boolean mute) {
		volumeLevel = 0;
		IVolum.super.setMute(mute);
	}

}
