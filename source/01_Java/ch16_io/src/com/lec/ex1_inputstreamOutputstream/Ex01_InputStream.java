package com.lec.ex1_inputstreamOutputstream;

import java.io.*;



//1. 파일을 연다(Stream객체를 생성한다.) 2. 데이터를 읽는다(read메소드 사용) 3. 파일을 닫는다(close메소드 사용)
public class Ex01_InputStream {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			//1번
			is = new FileInputStream("txtFile/inTest.txt");
			//2번
			while(true) {
				int i = is.read();// 1byte씩 읽는다.
				if(i == -1) {
					break; // 파일의 끝이면 break
				}
				System.out.print((char)i);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally { //3번
			try {
				if(is != null) {					
					is.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
