package com.lec.Quiz;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sawoon {
	public static final String COMPUTER = "전산실";
	public static final String PLAYING = "비서실";
	public static final String DESIGN = "설계팀";
	private String no;
	private String name;
	private String dept;
	private Date hiredate;
	public Sawoon(String no, String name, String dept) {
		super();
		this.no = no;
		this.name = name;
		this.dept = dept;
		this.hiredate = new Date();
	}
	public Sawoon(String no, String name, String dept, int y, int m, int d) {
		super();
		this.no = no;
		this.name = name;
		this.dept = dept;
		this.hiredate = new Date(new GregorianCalendar(y,m-1,d).getTimeInMillis());
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yy년 MM월 dd일(E)"); 
		return "Sawoon [사번] = " + no + ", [이름] = " + name + ", [부서] =" + dept + ", [입사일] = " + sdf.format(hiredate);
	}
	
	
	
}
