package com.lec.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Emp {
	private int empno;
	private String ename;
	private String job;
	private String mgr;
	private Date hiredate;
	private int sal;
	private int comm;
	private int deptno;
}
