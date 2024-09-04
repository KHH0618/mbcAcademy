package com.lec.ex5_person;

public class PersonMain {

	public static void main(String[] args) {
		Person[] person = {new Person("홍길동", 24, 'M'), 
						   new Person("홍길순", 25, 'F', "2000-10-30")};
//		for (int idx = 0; idx < person.length; idx++) {
//			person[idx].print();
//			System.out.println("---------------------------------");
//		}
		
		for (Person info : person) {
			System.out.println(info.infoString());
			System.out.println("---------------------------------");
		}

	}

}
