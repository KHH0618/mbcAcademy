package com.lec.ex2_readerWriter;

import java.io.*;

public class Ex01_reader {
	public static void main(String[] args) {
		Reader reader = null;
		try {
			reader = new FileReader("txtFile/inTest.txt");
			while(true) {
				int i = reader.read();
				if(i == -1) {
					break;
				}
				System.out.print((char) i);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(reader!=null) {
					reader.close();					
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
