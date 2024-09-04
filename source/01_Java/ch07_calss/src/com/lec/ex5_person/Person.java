package com.lec.ex5_person;
//데이터 : name, age, gender, birth(String => 13장 수업후에는 Date형)
//생성자 : new Person("홍길동", 22, '남', "2001-12-01"),new Person("홍길동", 22, '남') - 오버로딩
//메소드 : print()
public class Person {
	//인스턴스 변수
	private String name, birth;
	private int age;
	private char gender;
	
	
	//생성자
	public Person(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public Person(String name, int age, char gender, String birth) {
		this.name = name;
		this.birth = birth;
		this.age = age;
		this.gender = gender;
	}
	
	public void print() {
		System.out.printf("이름 = %s \n나이 = %d \n생일 = %s \n성별 = %s\n",name,age,(birth==null? "-":birth),gender=='M'? "남자":"여자");
	}
	
	public String infoString() {
		String result = "이름 : " + name;
		result += "\n나이 : " + age;
		result += "\n생일 : " + (birth==null? "-":birth);
		result += "\n성별 : " + (gender=='M'? "남자":"여자");
		
		return result;
		
		///return String.format("이름 = %s \n나이 = %d \n생일 = %s \n성별 = %s\n",name,age,birth,gender=='M'? "남자":"여자");
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
}
