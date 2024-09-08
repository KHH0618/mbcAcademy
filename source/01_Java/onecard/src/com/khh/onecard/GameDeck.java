package com.khh.onecard;

import java.util.*;

public class GameDeck {
	private String[] defaultDeck = { "S-02", "S-03", "S-04", "S-05", "S-06", "S-07", "S-08", "S-09", "S-10", "S-A",
			"S-J", "S-Q", "S-K", "C-02", "C-03", "C-04", "C-05", "C-06", "C-07", "C-08", "C-09", "C-10", "C-A", "C-J",
			"C-Q", "C-K", "H-02", "H-03", "H-04", "H-05", "H-06", "H-07", "H-08", "H-09", "H-10", "H-A", "H-J", "H-Q",
			"H-K", "D-02", "D-03", "D-04", "D-05", "D-06", "D-07", "D-08", "D-09", "D-10", "D-A", "D-J", "D-Q",
			"D-K", };
	private static LinkedList<String> gameDeck = new LinkedList<String>();
	private static LinkedList<String> userDeck = new LinkedList<String>();
	private static LinkedList<String> cpuDeck = new LinkedList<String>();
	private static LinkedList<String> fildDeck = new LinkedList<String>();

	public void gameDeckAdd() { // 처음 한번만 실행
		for (int i = 0; i < defaultDeck.length; i++) {
			gameDeck.add(defaultDeck[i]);
		}
	}

	public void cardShuffle() { // 처음 한번만 실행
		GameDeck gamedeck = new GameDeck();
		gamedeck.gameDeckAdd();
		for (; userDeck.size() < 5;) {
			int idx = (int) (Math.random() * (gameDeck.size() - 1));
			userDeck.add(gameDeck.get(idx));
			gameDeck.remove(idx);
		}
		for (; cpuDeck.size() < 5;) {
			int idx = (int) (Math.random() * (gameDeck.size() - 1));
			cpuDeck.add(gameDeck.get(idx));
			gameDeck.remove(idx);
		}

		int idx = (int) (Math.random() * (gameDeck.size() - 1));
		fildDeck.add(gameDeck.get(idx));
		gameDeck.remove(idx);

	}

	public void draw(boolean user) {
		int idx = (int) (Math.random() * (gameDeck.size() - 1));
		if (user) {
			userDeck.add(gameDeck.get(idx));
			gameDeck.remove(idx);
		} else if (!user) {
			userDeck.add(gameDeck.get(idx));
			gameDeck.remove(idx);
		}
	}

	public static void main(String[] args) {
		GameDeck gd = new GameDeck();
		gd.cardShuffle();
		for (String i : gd.userDeck) {
			System.out.print(i + "\t");
		}
		System.out.println();
		for (String i : gd.cpuDeck) {
			System.out.print(i + "\t");
		}
		System.out.println();
		for (String i : gd.fildDeck) {
			System.out.print(i + "\t");
		}
		System.out.println();
		System.out.println(gd.gameDeck.size());
	}

	public static String toStirngFildDeckList() {
		return fildDeck.get(fildDeck.size() - 1);
	}

	// setter & getter
	public String[] getDefaultDeck() {
		return defaultDeck;
	}

	public void setDefaultDeck(String[] defaultDeck) {
		this.defaultDeck = defaultDeck;
	}

	public static LinkedList<String> getGameDeck() {
		return gameDeck;
	}

	public static void setGameDeck(LinkedList<String> gameDeck) {
		GameDeck.gameDeck = gameDeck;
	}

	public static LinkedList<String> getUserDeck() {
		return userDeck;
	}

	public static void setUserDeck(LinkedList<String> userDeck) {
		GameDeck.userDeck = userDeck;
	}

	public static LinkedList<String> getCpuDeck() {
		return cpuDeck;
	}

	public static void setCpuDeck(LinkedList<String> cpuDeck) {
		GameDeck.cpuDeck = cpuDeck;
	}

	public static LinkedList<String> getFildDeck() {
		return fildDeck;
	}

	public static void setFildDeck(LinkedList<String> fildDeck) {
		GameDeck.fildDeck = fildDeck;
	}

}
