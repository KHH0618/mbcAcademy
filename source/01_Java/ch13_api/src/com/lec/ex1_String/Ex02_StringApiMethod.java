package com.lec.ex1_String;

public class Ex02_StringApiMethod {
	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = "AbCXabc";
		String str3 = "  ja  va  ";
		String str4 = "abcXabcXabcXabc";
		String str5 = "반가워요. ㅋㅋ 또 봐요 ㅎㅎzz";
		System.out.println("1."+str1.concat(str2));//두 문자열을 붙여서 반환
		System.out.println("2."+str1.substring(3));//문자열의 3번째 인덱스부터 끝까지 반환
		System.out.println("3."+str1.substring(3, 5));//문자열의 3번째 인덱스부터 5번째 인덱스 앞까지 반환
		System.out.println("4."+str1.length());// 문자열 길이
		System.out.println("5."+str1.toUpperCase());// 모두 대문자로
		System.out.println("6."+str1.toLowerCase());// 모두 소문자로
		System.out.println("7."+str1.charAt(3));// 3번째 인덱스 글자
		System.out.println("8."+str1.indexOf("b"));// 해당 문자의 첫번째 인덱스를 반환 없으면 -1
		System.out.println("9."+str1.indexOf("bc",2));// 해당 문자의 n번째 인덱스를 반환 없으면 -1		
		System.out.println("10."+str4.lastIndexOf("bc"));// 해당 문자의 마지막 인덱스를 반환 없으면 -1
		System.out.println("11."+str4.indexOf("@"));// 없는 문자열은 -1 반환
		System.out.println("12."+str1.equals(str4));// false: 비교
		System.out.println("13."+str1.equalsIgnoreCase(str2));//true: 대소문자 구분없이 비교
		System.out.println("14."+str3.trim());//앞뒤 스페이스를 제거
		//문자열.replace(oldStr, newStr)
		//문자열.replaceAll(oldStr정규표현식, newStr)
		//[0-9]숫자
		System.out.println("15."+str1.replace("abc","바꿔"));//abc문자열을 바꿔 로 바꿔서 반환
		System.out.println("16."+str5.replaceAll("[ㄱ-ㅎz]",""));//정규표현식 문자 삭제		
		
		System.out.println("str1 = " + str1);
		System.out.println("str2 = " + str2);
	}
}
