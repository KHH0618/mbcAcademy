package com.lec.ex4_Object;

//Person p1 = new Person()
//Person p2 = new Person(1355433122025L)
//Person p3 = new Person(1355433122025L)
//p1.equals(p2) => true
//System.out.println(p1) => 주민번호는 1355433122025입니다.
public class Person {
	private long juminNo;

	public Person(long juminNo) {
		this.juminNo = juminNo;
	}

	@Override
	public String toString() {
		return "주민 번호는 : " + juminNo;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj!=null && obj instanceof Person) {
			Person other = (Person)obj;
			boolean juminNochk = juminNo == other.juminNo;
			if(juminNochk) {
				return true;
			}
		}
		return false;
	}
}
