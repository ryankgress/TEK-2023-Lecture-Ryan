package com.tek.java.day6.implement;

public abstract class Shape implements AreaCalculation {
	private String name;
	
	public void setShapeName(String name) {
		this.name = name;
	}
	
	public String getShapeName() {
		return name;
	}


}
