package com.khh.onecard;

import java.util.*;

public class GameDeck {
	private String [] defaultDeck = {
			"S-2","S-3","S-4","S-5","S-6","S-7","S-8","S-9","S-10","S-A","S-J","S-Q","S-K",
			"C-2","C-3","C-4","C-5","C-6","C-7","C-8","C-9","C-10","C-A","C-J","C-Q","C-K",
			"H-2","H-3","H-4","H-5","H-6","H-7","H-8","H-9","H-10","H-A","H-J","H-Q","H-K",
			"D-2","D-3","D-4","D-5","D-6","D-7","D-8","D-9","D-10","D-A","D-J","D-Q","D-K",			
	};
	private static LinkedList <String> gameDeck = new LinkedList <String>();
	private static LinkedList<String> userDeck = new LinkedList<String>();
	private static LinkedList<String> cpuDeck = new LinkedList<String>();
	private static LinkedList<String> fildDeck = new LinkedList<String>();
	
	public void gameDeckAdd() {
		for(int i = 0; i<defaultDeck.length; i++) {
			gameDeck.add(defaultDeck[i]);
		}
	}
	
	public void cardShuffle() {
		GameDeck gamedeck = new GameDeck();
		gamedeck.gameDeckAdd();
		for (;userDeck.size()<5;) {
			int idx = (int)(Math.random() * (gameDeck.size()-1));
			userDeck.add(gameDeck.get(idx));
			gameDeck.remove(idx);
		}
		for (;cpuDeck.size()<5;) {
			int idx = (int)(Math.random() * (gameDeck.size()-1));
			cpuDeck.add(gameDeck.get(idx));
			gameDeck.remove(idx);
		}
		
		int idx = (int)(Math.random() * (gameDeck.size()-1));
		fildDeck.add(gameDeck.get(idx));
		gameDeck.remove(idx);
		
	}

	public static void main(String[] args) {
		GameDeck gd = new GameDeck();
		gd.cardShuffle();
		for(String i : gd.userDeck) {
			System.out.print(i+"\t");
		}
		System.out.println();
		for(String i : gd.cpuDeck) {
			System.out.print(i+"\t");
		}
		System.out.println();
		for(String i : gd.fildDeck) {
			System.out.print(i+"\t");
		}
	}
}
