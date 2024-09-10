package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.Arrays;

public class Ex01_ArrayList {
	public static void main(String[] args) {
		String[] array = new String [2];
		array[0] = "str0";
		array[1] = "str1";
//		array[2] = "str2";
		System.out.println(Arrays.toString(array));
		for (String arr : array) {
			System.out.print(arr + "\t");
		}
		for (int i = 0; i<array.length; i ++) {
			System.out.print(array[i] + "\t");
		}
		System.out.println();
		System.out.println("---------------------------------------------------");
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("str0");
		arrayList.add("str1");
		arrayList.add("str2");
		arrayList.set(1, " s t r 1");//arrayList 1번index 수정
		for (String arr : arrayList) {
			System.out.print(arr+"\t");
		}
		for (int i = 0; i<arrayList.size(); i ++) {
			System.out.print(arrayList.get(i)+"\t");
		}		
		System.out.println();
		System.out.println("-----------------------------------------------------");
		arrayList.remove(1);
		System.out.println(arrayList);
		arrayList.remove(arrayList.size()-1);
		System.out.println(arrayList);
		System.out.println(arrayList.isEmpty()? "arrayList데이터가 없음":"데이터가 있음");
		arrayList.clear();//arrayList의 모든 데이터 제거
		System.out.println(arrayList);
		System.out.println(arrayList.isEmpty()? "arrayList데이터가 없음":"데이터가 있음");
		System.out.println(arrayList.size());
	}
}
