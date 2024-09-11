package com.khh.tutorials.Individual;
import java.util.Random;
import java.util.Scanner;
public class P0006 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random cpu = new Random();
		int i = 0;
		boolean br31 = true;
		while (br31) {
			boolean zero = true;
			if (i == 31 || i>=31) {
				System.out.println("USER가 승리했습니다.");
				br31 = false;
				break;
			}
			int cputurn = cpu.nextInt(4);
			
			if(cputurn != 0) {
				 System.out.println("CPU차례입니다.");
				 System.out.println("CPU수는 " +cputurn+"입니다.");
				 i = i + cputurn;
			 }else if (cputurn == 0){
				 while (zero) {
					 cputurn = cpu.nextInt(4);
					 if (cputurn != 0) {
						 zero = false;
					 }else {
						 cputurn = cpu.nextInt(4);
					 }
				 }
				 System.out.println("CPU차례입니다.");
				 System.out.println("CPU수는 " +cputurn+"입니다.");
				 i = i + cputurn;
			 }
			
			if (i == 31 || i>=31) {
				System.out.println("cpu가 승리했습니다.");
				br31 = false;
				break;
			}
			System.out.println("지금까지 총 수의 합은 " +i+"입니다.");
			System.out.println("user차례입니다.");
			int userturn = input.nextInt();
			if(userturn<4) {
				if(0<userturn) {
					System.out.println("user수는 " +userturn+"입니다.");
					i = i + userturn;
					System.out.println("지금까지 총 수의 합은 " +i+"입니다.");
				}else 
				{
					while (zero) {
					   System.out.println("1~3의 수를 입력하세요.");
					   userturn = input.nextInt();
					   if (userturn<4) {
						   if(0<userturn) {
							   zero = false;
						   }
					   }
					}
				}
			}
			else 
			{
				while (zero) {
				   System.out.println("1~3의 수를 입력하세요.");
				   userturn = input.nextInt();
				   if (userturn<4) {
					   if(0<userturn) {
						   zero = false;
					   }
				   }
				}
			}
	}
  }
}
