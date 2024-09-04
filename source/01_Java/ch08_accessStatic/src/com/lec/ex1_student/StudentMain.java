package com.lec.ex1_student;

public class StudentMain {
	public static void main(String[] args) {
		Student[] students = {new Student("정우성", 90, 90, 90),
							 new Student("김하늘", 90, 90, 91),
							 new Student("황정민", 80, 80, 80),
							 new Student("강동원", 80, 80, 81),
							 new Student("마동석", 70, 70, 70)};
		Line line = new Line();
		int[] tot = new int[5];
		
		
		line.line("■", 59);
		line.start();
		for(Student student : students) {
			student.infoPrint();
			tot[0] += student.getKor();
			tot[1] += student.getEng();
			tot[2] += student.getMat();
			tot[3] += student.getTot();
			tot[4] += student.getAvg();
		}
		
		
		System.out.print("\t");
		line.line("-", 43);
		System.out.print("\t총점");
		for(int total : tot) {
			System.out.printf("\t%d",total);
		}
		System.out.println();
		line.line("■", 59);
	}
}
