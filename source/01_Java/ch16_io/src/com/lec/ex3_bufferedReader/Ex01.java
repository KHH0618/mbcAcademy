package com.lec.ex3_bufferedReader;

import java.io.*;

public class Ex01 {
	public static void main(String[] args) {
		Reader reader = null;
		BufferedReader br = null;
		
		try {
			reader = new FileReader("txtFile/inTest.txt");//기본 스트림 객체 생성
			br = new BufferedReader(reader);//보조 스트림 객체 생성
			while (true) {
				String line = br.readLine();
				if(line == null) {
					break;
				}
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if (br != null) {					
					br.close();
				}
				if(reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
