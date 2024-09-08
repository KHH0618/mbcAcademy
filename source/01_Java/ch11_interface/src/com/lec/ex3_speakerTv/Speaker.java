package com.lec.ex3_speakerTv;

public class Speaker implements IVolum {
	private int volumeLevel;
	private final int SPEAKER_MAX_VILUME =100;
	private final int SPEAKER_MIN_VILUME =1;
	
	
	
	public Speaker(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}

	@Override
	public void volumeUp() {
		
		if((volumeLevel+5) < SPEAKER_MAX_VILUME) {
			volumeLevel+=5;
			System.out.println("스피커 볼륨을 5만큼 올려 현재"+volumeLevel);
		}else if(volumeLevel <= SPEAKER_MAX_VILUME) {
			int temp = SPEAKER_MAX_VILUME -volumeLevel;
			volumeLevel = SPEAKER_MAX_VILUME;
			System.out.println("스피커 볼륨을" + temp + "올렸습니다.현재 "+volumeLevel);
		}else {
			System.out.println("스피커 볼륨이 최대치여서 올리지 못했습니다.");
		}

	}
	
	@Override
	public void volumeUp(int i) {
		if((volumeLevel+i) < SPEAKER_MAX_VILUME) {
			volumeLevel+=i;
			System.out.println("스피커 볼륨을 "+i+"만큼 올려 현재"+volumeLevel);
		}else if(volumeLevel <= SPEAKER_MAX_VILUME) {
			int temp = SPEAKER_MAX_VILUME -volumeLevel;
			volumeLevel = SPEAKER_MAX_VILUME;
			System.out.println("스피커 볼륨을" + temp + "올렸습니다. 현재 "+volumeLevel);
		}else {
			System.out.println("스피커 볼륨이 최대치여서 올리지 못했습니다.");
		}
	}

	@Override
	public void volumeDown() {
		if((volumeLevel-5) > SPEAKER_MIN_VILUME) {
			volumeLevel-=5;
			System.out.println("스피커 볼륨을 5만큼 내려 현재 "+volumeLevel);
		}else if(volumeLevel > SPEAKER_MIN_VILUME){
			int temp = volumeLevel - SPEAKER_MIN_VILUME;
			volumeLevel = SPEAKER_MIN_VILUME;
			System.out.println("스피커 볼륨을" + temp + "만큼 내렸습니다. 현재 "+volumeLevel);
		}else {
			System.out.println("스피커 볼륨이 최소치여서 내리지 못했습니다.");
		}

	}
	
	@Override
	public void volumeDown(int i) {
		if((volumeLevel-i) > SPEAKER_MIN_VILUME) {
			volumeLevel-=i;
			System.out.println("스피커 볼륨을 "+i+"만큼 내려 현재"+volumeLevel);
		}else if(volumeLevel > SPEAKER_MIN_VILUME){
			int temp = volumeLevel - SPEAKER_MIN_VILUME;
			volumeLevel = SPEAKER_MIN_VILUME;
			System.out.println("스피커 볼륨을" + temp + "만큼 내렸습니다. 현재 "+volumeLevel);
		}else {
			System.out.println("스피커 볼륨이 최소치여서 내리지 못했습니다.");
		}
	}
	
	@Override
	public void setMute(boolean mute) {
		volumeLevel = 0;
		IVolum.super.setMute(mute);
	}

}
