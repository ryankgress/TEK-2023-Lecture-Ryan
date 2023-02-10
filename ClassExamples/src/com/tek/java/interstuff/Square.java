package com.tek.java.interstuff;

public class Square extends Shape{
	
	public static String x = "100";		// This exists only once in the JVM
	
	@Override
	public void printShape() {
		super.printShape();  			// Running shape.printShape() essentially
		System.out.println("Showing how overrides work.");
	}
	
	public void printSquare() {
		System.out.println("I am a square.");
	}
	
	public void squareSize() {
//		shapesize();	// Cannot access because shapesize() is private
	}
}
