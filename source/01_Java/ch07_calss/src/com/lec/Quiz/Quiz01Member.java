package com.lec.Quiz;

public class Quiz01Member {
	private String id , pw, name, email, address, birth;
	private char gender;

	// 생성자
	public Quiz01Member(String id, String pw, String name, String email, String address, String birth, char gender) {
		this.address = address; 
		this.birth = birth;
		this.email = email;
		this.gender = gender;
		this.name = name;
		this.id = id;
		this.pw = pw;
		if(gender == 'M') {
			this.gender = '남';
		}else if (gender == 'F') {
			this.gender = '여';
		}
	}
	
	public void print() {
		System.out.println("아이디 =" + id );
		System.out.println("이름 = "+ name);
		System.out.println("이메일 = " + email);
		System.out.println("주소 = " +address);
		System.out.println("생일 = " +birth);
		System.out.println("성별 = " +gender);
	}
	
	public void login(String id, String pw) {
		
		if(this.id.equals(id)) {
			if(this.pw.equals(pw)) {
				System.out.println("로그인 되었습니다.");
				print();
			}else {
				System.out.println("비밀번호가 틀렸습니다.");
			}
		}else {
			System.out.println("아이디가 틀렸습니다.");
		}
	}
}
