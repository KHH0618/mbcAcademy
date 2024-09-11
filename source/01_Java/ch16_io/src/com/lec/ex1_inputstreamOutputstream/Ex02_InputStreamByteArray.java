package com.lec.ex1_inputstreamOutputstream;
//1. 파일을 연다(Stream객체를 생성한다.) 2. 데이터를 읽는다(read메소드 사용) 3. 파일을 닫는다(close메소드 사용)
import java.io.*;

public class Ex02_InputStreamByteArray {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("txtFile/inTest.txt");
			byte[] bs = new byte[10];//10byte씩 bs에 읽어오는 용도
			while(true) {
				int byteCount = is.read(bs);
				if(byteCount == -1) {
					break;
				}
				for(int i = 0; i<byteCount; i++) {
					System.out.print((char)bs[i]);
				}
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
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
