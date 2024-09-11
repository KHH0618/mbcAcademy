package com.lec.ex2_readerWriter;

import java.io.*;

public class Ex02_writer {
	public static void main(String[] args) {
		Writer writer = null;
		try {
			writer = new FileWriter("txtFile/outTest.txt",true);
			String mag = "안녕 자바! \n01234567 \nHello world";
			writer.write(mag);
			mag ="두번째";
			writer.write(mag);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(writer != null) {
					writer.close();					
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
