package com.tek.java.sba1;

import java.util.Arrays;

/**
 * Will need to implement 2 classes
 * @author ryank
 *
 */

public class Question2 {
	
	private static final int ARRAY_SIZE = 5;
	private int[] array = new int[ARRAY_SIZE+1];
	
	public Question2() {
		Arrays.fill(array, -1);
	}

	public static void main(String[] args) {
		Question2 q2 = new Question2();
		int[] arr = new int[ARRAY_SIZE+1];		// Going from a 0-based array in java to a 1-based array for the question
		
		// initialize the array to a value
		Arrays.fill(arr, -1);
		
		int[] newArr = {1,2,3,4,7,8};
		
		q2.calculateAverage(newArr);
		
		for(int i : arr) {
			System.out.print(i + " | ");
		}
		
	}
	
	// Calculate avg of the array. Display in decimal format using %.2f
	public void calculateAverage(int[] arr) {
		double avg = 0;
		int count = 0;
		
		for(int i : arr) {
			avg += i;
			count++;
		}
		
		avg /= count;
		
		System.out.printf("%.2f%n", avg);
	}
	
	/**
	 * If value at inx == 1, print message and set value to something
	 * Otherwise, 
	 * @param inx
	 */
	public void setValue(int inx) {
		if(array[inx] == -1) {
			array[inx] = 1;
			System.out.println("Array value is now 1.");
		} else {
			System.out.println("Array value is already 1");
		}
	}
	
	public void move(int value, int inx) {
		if(array[inx] == value) {
			System.out.println("Value with id: " + inx + " is moved to " + value);
			array[inx] = -1;
		} else {
			System.out.println("Value is already -1");
		}
	}
	

}
