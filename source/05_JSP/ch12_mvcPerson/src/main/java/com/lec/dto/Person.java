package com.lec.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Person {
	private int id;
	private String name;
	private String tel;
	private String address;
	private Date birth;
	private String memo;
	private Date rdate;
	public Person(String name, String tel, String address, Date birth, String memo) {
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.birth = birth;
		this.memo = memo;
	}
	public Person(int id, String name, String tel, String address, Date birth, String memo) {
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.birth = birth;
		this.memo = memo;
	}
	
}
