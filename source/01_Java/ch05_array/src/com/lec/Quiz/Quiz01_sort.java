package com.lec.Quiz;

import java.util.Arrays;

//76,45,34,89,50  5개의 값을 배열로 초기화 하고 이들 값들을 크기 순으로 나타내는 프로그램을 작성 하시요
public class Quiz01_sort {
	public static void main(String[] args) {
		int [] arr = {76,45,34,89,50};
		
		for(int i = 0; i<arr.length-1; i++) {
			for(int j = i+1; j<arr.length; j++) {
				if(arr[i]>arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}//if문 닫음
			}//중첩 for문 닫음
		}//for문 닫음
		
		System.out.println(Arrays.toString(arr));
	}
}
