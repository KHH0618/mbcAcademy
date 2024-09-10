package com.lec.ex3_excptions;

import java.text.SimpleDateFormat;
import java.util.Date;

//데이터 : 이름 전화번호 생년월일(Date)
//Friend f = new Friend("홍길동", "010-9999-9999", new Date(98,8,10))
//sysout(f) => [이름]홍길* [전화]***-****-9999 [생일] 9월10일

public class Friend {
	private String name, tel, brtsdf;
	private Date brt;
	
	public Friend(String name) {
		super();
		this.name = name;
	}

	public Friend(String name, String tel) {
		super();
		this.name = name;
		this.tel = tel;
	}
	
	public Friend(String name, String tel, Date brt) {
		super();
		this.name = name;
		this.tel = tel;
		this.brt = brt;
		this.brtsdf = new SimpleDateFormat("M월d일").format(this.brt);
	}
	
	//if문으로 간단히 표현할 수 있지만 try - catch를 사용해보기위해..
	@Override
	public String toString() {
		String result = "";
		String congrats = "";
		String today = new SimpleDateFormat("M월dd일").format(new Date());
		try {
			String nameOut = name.substring(0, name.length()-1) + "*";
			result += "[이름]" + nameOut;
		} catch (NullPointerException e) {
			result += "";
		}
		
		try {
			int telIdx = tel.lastIndexOf("-");
			String lastTel = tel.substring(telIdx);//정규표현식 수업이후에 파이썬으로 구현예정
			result += ", [전화번호]" + "***-****"+ lastTel;			
		} catch (NullPointerException e) {
			result += "";
		}
		
		try {
			if(brtsdf.equals(today)) {
				congrats = "추카추카";
			}
			result += ", [생일]" + brtsdf + " " +congrats;						
		} catch (NullPointerException e) {
			result += "";
		}
		return result;
	}
}
