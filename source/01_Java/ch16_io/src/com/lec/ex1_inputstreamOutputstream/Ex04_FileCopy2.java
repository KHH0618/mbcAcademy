package com.lec.ex1_inputstreamOutputstream;

import java.io.*;

public class Ex04_FileCopy2 {
	public static void main(String[] args) {		
		long start = System.currentTimeMillis();
		InputStream is = null;
		OutputStream os = null;
		try {
			File originalFile = new File("D:/KHH/ai/lecNote/bts_7.mp4");
			is = new FileInputStream(originalFile);
			os = new FileOutputStream("D:/KHH/ai/lecNote/bts_7_copy1.mp4");
			int cnt = 0;
			while(true) {
				byte[] bs = new byte[(int) originalFile.length()]; 
				int i = is.read(bs);
				if (i == -1) {
					break;
				}
				os.write(bs);
				cnt++;
				System.out.println(cnt);
			}
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if (os != null) {
					os.close();					
				}
				if (is != null) {
					is.close();
				}
				
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
			System.out.println("파일 복사 완료");
		}
		
		long end = System.currentTimeMillis();
		System.out.println((end-start)/1000.0+"초 걸림");
		
	}
}
