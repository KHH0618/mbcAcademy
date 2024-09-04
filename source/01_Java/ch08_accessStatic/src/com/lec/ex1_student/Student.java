package com.lec.ex1_student;

public class Student {
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avg;
	
	public Student() {}
	public Student(String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		
	}
	
	public void infoPrint() {
		tot = kor + eng + mat;
		avg = tot/3.;
		System.out.printf("\t%s\t%d\t%d\t%d\t%d\t%.1f\n",name, kor, eng, mat, tot, avg);
	}
	
	public String infoString() {
		tot = kor + eng + mat;
		avg = tot/3.;
		return String.format("\t%s\t%d\t%d\t%d\t%d\t%.1f\n",name, kor, eng, mat, tot, avg);
	}
	
	
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	
	
}
