package com.lec.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.lec.dao.PersonRepository;
import com.lec.dto.Person;

public class JavaProgram {
	public static void main(String[] args) {
		String pname;
		String jname;
		String jnameall;
		int kor;
		int eng;
		int mat;
		PersonRepository pr = PersonRepository.getINSTANCE();
		Scanner scanner = new Scanner(System.in);
		int roop = 0;		
		ArrayList<String> jnames = pr.jnameList();

		do {
			System.out.println("1.[입력] 2.[직업별출력] 3.[전체출력] 그 외 종료");
			roop = scanner.nextInt();
			switch (roop) {
				case 1: {
					System.out.print("성합 : ");
					pname = scanner.next();
					System.out.print("직업명"+ jnames.toArray() + " : ");
					jname = scanner.next();
					System.out.print("국어 점수 : ");
					kor = scanner.nextInt();
					System.out.print("영어 점수 : ");
					eng = scanner.nextInt();
					System.out.print("수학 점수 : ");
					mat = scanner.nextInt();
					pr.insertPerson(pname, jname, kor, eng, mat);
					break;
				}
				case 2: {
					System.out.print("직업명"+ jnames +" : ");
					jname = scanner.next();
					for (Person person : pr.getPerson(jname)) {
						System.out.println(person);
					}
					break;
				}
				case 3: {
					for (Person person : pr.getPerson()) {
						System.out.println(person);
					}
					break;
				}

			}
		} while (roop == 1 || roop == 2 || roop == 3);
		
		scanner.close();
	}
}
