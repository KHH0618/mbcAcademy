package com.lec.ex4_actor;

public class ActorMain {
	public static void main(String[] args) {
		Actor hong = new Actor("홍길동");
		hong.makePizza();
		hong.makeSpaghetti();
		hong.outFire();
		hong.saveMan();
		hong.canCatchCriminal();
		hong.canSearch();
		
		IChef chefHong = hong;
		chefHong.makePizza();
		chefHong.makeSpaghetti();
//		chefHong.outFire();
//		chefHong.saveMan();
//		chefHong.canCatchCriminal();
//		chefHong.canSearch();
		
		IFireFighter firefighterHong = hong;
//		firefighterHong.makePizza();
//		firefighterHong.makeSpaghetti();
		firefighterHong.outFire();
		firefighterHong.saveMan();
//		firefighterHong.canCatchCriminal();
//		firefighterHong.canSearch();
		
		IPoliceMan policeHong = hong;
//		policeHong.makePizza();
//		policeHong.makeSpaghetti();
//		policeHong.outFire();
//		policeHong.saveMan();
		policeHong.canCatchCriminal();
		policeHong.canSearch();
	}
}
