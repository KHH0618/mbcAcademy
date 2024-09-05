package com.lec.ex3_speakerTv;

public class TestMain {
	public static void main(String[] args) {
		IVolum[] divices = {
				new Speaker(60),
				new Speaker(20),
				new TV(44),
				new TV(20),
		};
		
		IVolum.changeBattery();
		
		for(IVolum divice : divices) {
			divice.volumeDown(20);
			divice.volumeDown(21);
			divice.setMute(true);
			divice.volumeUp(20);
			divice.volumeUp(90);
			System.out.println("------------------------------");
		}
	}
}
