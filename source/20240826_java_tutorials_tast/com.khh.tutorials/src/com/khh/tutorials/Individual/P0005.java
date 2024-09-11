package com.khh.tutorials.Individual;
import java.util.Random;
import java.util.Scanner;
//배스킨라빈스31게임
public class P0005 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random cpu = new Random();
		for(int i = 0; i < 31;) {
			boolean zero = true;
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
			System.out.println("지금까지 총 수의 합은 " +i+"입니다.");
			System.out.println("user차례입니다.");
			int userturn = input.nextInt();
			if(userturn<4) {
				if(0<userturn) {
					System.out.println("user수는 " +userturn+"입니다.");
					i = i + userturn;
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
			System.out.println("지금까지 총 수의 합은 " +i+"입니다.");
		} 
	}
}
