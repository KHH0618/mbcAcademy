package com.lec.dto;

public class Person {
	private int pno;
	private String rank;
	private String pname;
	private int jno;
	private String jname;
	private int kor;
	private int eng;
	private int mat;
	private int total;
	
	public Person (String jname) {
		this.jname = jname;
	}

	public Person(String rank, String pname, String jname, int kor, int eng, int mat, int total) {
		this.rank = rank;
		this.pname = pname;
		this.jname = jname;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.total = total;
	}

	

	@Override
	public String toString() {
		return rank + "\t" + pname + "\t" + jname + "\t" + kor + "\t" + eng
				+ "\t" + mat + "\t" + total;
	}
	
	

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getJno() {
		return jno;
	}

	public void setJno(int jno) {
		this.jno = jno;
	}

	public String getJname() {
		return jname;
	}

	public void setJname(String jname) {
		this.jname = jname;
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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
	
	
}
