package com.tek.java.day6.implement;

import java.text.DecimalFormat;

public class Circle extends Shape {
	private int radius;
	private static final double PI = 3.14;

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return PI * Math.pow(radius, 2);
	}
	
//	@Override
//	public String toString() {
//		return "The area of " + getShapeName() + " (radius=" + radius + ") is " + calculateArea();
//	}
	
//	private String formatNumber(double d) {
//		DecimalFormat twoSpaces = new DecimalFormat("###,###.##");
//		return twoSpaces.format(d);
//	}

	
}
