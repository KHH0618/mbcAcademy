package com.lec.ex1_inputstreamOutputstream;

import java.io.*;

public class Ex04_FileCopy {
	public static void main(String[] args) {		
		long start = System.currentTimeMillis();
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("D:/KHH/ai/lecNote/bts_7.mp4");
			os = new FileOutputStream("D:/KHH/ai/lecNote/bts_7_copy.mp4");
			int cnt = 0;
			while(true) {
				int i = is.read();
				if (i == -1) {
					break;
				}
				os.write(i);
				cnt++;
				if(cnt%125000 == 0) {
					System.out.println(cnt+"/7,460,545");					
				}
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
