package com.tek.java.day6.implement;

public class Triangle extends Shape {
	private int base;
	private int height;

	public void setBase(int base) {
		this.base = base;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public double calculateArea() {
		int area = base * height / 2;
		return area;
	}

	// Can override even basic Object methods
	@Override
	public String toString() {
		return "The area of " + getShapeName() + " (base=" + base + ", height=" + height + ") is "
				+ calculateArea();
	}

}
