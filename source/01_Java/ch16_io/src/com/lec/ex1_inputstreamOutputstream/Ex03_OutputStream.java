package com.lec.ex1_inputstreamOutputstream;

import java.io.*;

//파일열기(Stream객체 생성) -> 파일쓰기 -> 파일닫기(Stream객체 close)
public class Ex03_OutputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			// 1번. 파일열기
			os = new FileOutputStream("txtFile/outTest.txt",true);// true:append, 생략하거나 false : 덮어쓰기
			String mag = "Hello,world \nHi, Ai\n";
			byte[] bs = mag.getBytes();// String ->byte배열
			// 2번. 데이터쓰기
			os.write(bs);
			System.out.println("파일출력성공");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try { //3.파일닫기
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
