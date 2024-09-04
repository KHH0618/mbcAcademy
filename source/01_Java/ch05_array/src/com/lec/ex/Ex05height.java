package com.lec.ex;

import java.util.Scanner;

//배열을 이용하여 학생들 (길동, 현식, 땅땅, 슘당, 대갈)의 키를 입력받아 평균치,최장신 학생의 이름과 키, 최단신 학생의 이름과 키를 구하여라
public class Ex05height {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] names = { "길동", "현식", "땅땅", "슘당", "대갈" };
		int[] height = new int[names.length];
		double sum = 0;

		for (int idx = 0; idx < names.length; idx++) {
			System.out.printf("%s의 키를 입력하세요 >\t", names[idx]);
			int hit = scanner.nextInt();
			height[idx] = hit;
			sum += hit;
		}

		for (int idx = 0; idx < names.length; idx++) {
			System.out.printf("%s의 키는 %d 입니다\n", names[idx], height[idx]);
		}

		System.out.printf("5명의 키 평균은 %.2f 입니다\n", sum / height.length);
		scanner.close();

		String minname = names[0];//작은친구 이름
		int minhit = height[0];//작은친구 키
		
		String maxname = names[0];//큰친구 이름
		int maxhit = height[0];//큰친구 키
		
		for (int idx = 0; idx < names.length; idx++) {
			if (maxhit < height[idx]) {
				maxhit = height[idx];
				maxname = names[idx];
			} else if (minhit > height[idx]) {
				minhit = height[idx];
				minname = names[idx];
			}
		}
		System.out.printf("최 장신의 %s의 키는 %d 입니다\n", maxname, maxhit);
		System.out.printf("최 단신의 %s의 키는 %d 입니다\n", minname, minhit);
	}
}
