package com.lec.ch07.ex2Rect;


public class Rect {
	private int width;
	private int height;
	
	//생성자
	public Rect() {}
	public Rect(int side) {width = height = side;}
	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public int area() {
		return width * height;
	}
	
	//setter & getter
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	
}
