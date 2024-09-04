package com.lec.conditionQuiz;
//현재 몇월인지를 키보드로부터 입력받아 계절을 출력하는 프로그램을 구현하세요
import java.util.Scanner;
public class Quiz05 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("지금은 몇월 인가요? > ");
		int moth = scanner.nextInt(); //키보드로 입력받기
		//아래 함수는 계절을 분기별로 전환, 좀더 다듬을수있을것같음
		if(0<moth&&moth<13) {
			int quarter = 0;
			if(moth == 12 || moth == 1 || moth == 2) {
				quarter = 1;
			}else if (moth == 3 || moth == 4 || moth == 5){
				quarter = 2;
			}else if (moth == 6 || moth == 7 || moth == 8) {
				quarter = 3;
			}else if (moth == 9 || moth == 10 || moth == 11) {
				quarter = 4;
			}
			String season;
			switch(quarter) {
				case 1 : season = "winter"; break;
				case 2 : season = "spring"; break;
				case 3 : season = "summer"; break;
				default : season = "autumn";
			}
			System.out.println(season);
		}else {
			System.out.println("1~12 사이의 값을 입력해주세요, 프로그램을 다시 실행해 주세요");
			System.exit(0);
		}
		scanner.close();
	}
}
