package com.khh.onecard;

public class GameUI {
	public static void userCardUi(String cardPain, String cardNum, int loopNum) {
		String[] userCard = {
			"┌───────┐","└───────┘"	,"│\t│",String.format("│   %s   │", cardPain),String.format("│     %s│", cardNum)
		};
		
	       for (int i = 0; i<loopNum; i++) {System.out.print(userCard[0]+"\t");}
	       System.out.println();
	       for (int i = 0; i<loopNum; i++) {System.out.print(userCard[4]+"\t");}
	       System.out.println();
	       for (int i = 0; i<loopNum; i++) {System.out.print(userCard[2]+"\t");}
	       System.out.println();
	       for (int i = 0; i<loopNum; i++) {System.out.print(userCard[3]+"\t");}
	       System.out.println();
	       for (int i = 0; i<loopNum; i++) {System.out.print(userCard[2]+"\t");}
	       System.out.println();
	       for (int i = 0; i<loopNum; i++) {System.out.print(userCard[1]+"\t");}
	       System.out.println();
	        
	}
	
	public static void cpuCardUi(int loopNum) {
		String[] cpuCard= {
				"┌───────┐","└───────┘"	,"│▒▒▒▒▒▒▒│"
		};
		for (int i = 0; i<loopNum; i++) {System.out.print(cpuCard[0]+"\t");}
	    System.out.println();
	    for (int i = 0; i<loopNum; i++) {System.out.print(cpuCard[2]+"\t");}
	    System.out.println();
	    for (int i = 0; i<loopNum; i++) {System.out.print(cpuCard[2]+"\t");}
	    System.out.println();
	    for (int i = 0; i<loopNum; i++) {System.out.print(cpuCard[2]+"\t");}
	    System.out.println();
	    for (int i = 0; i<loopNum; i++) {System.out.print(cpuCard[2]+"\t");}
	    System.out.println();
	    for (int i = 0; i<loopNum; i++) {System.out.print(cpuCard[1]+"\t");}
	    System.out.println();
	}
	
	public static void fildCardUi(String cardPain, String cardNum) {
		String[] fildCard = {
				"┌───────┐","└───────┘"	,"│\t│",String.format("│   %s   │", cardPain),String.format("│     %s│", cardNum)
		};
		System.out.print("\t"+fildCard[0]+"\n");
		System.out.print("\t"+fildCard[4]+"\n");
		System.out.print("\t"+fildCard[2]+"\n");
		System.out.print("\t"+fildCard[3]+"\n");
		System.out.print("\t"+fildCard[2]+"\n");
		System.out.print("\t"+fildCard[1]+"\n");
	}
	
	
	public static void main(String[] args) {
		userCardUi("A","10",5);
		//cpuCardUi(3);
		//fildCardUi("A","08");
	}
}
