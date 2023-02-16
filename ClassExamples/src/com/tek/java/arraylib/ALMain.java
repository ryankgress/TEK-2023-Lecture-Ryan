package com.tek.java.arraylib;

public class ALMain {

	public static void main(String[] args) {
		ArrayLibrary al = new ArrayLibrary();
		
		int[] numbers = new int[10];
		
		// Initialize w/ number from 1-10
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = i+1;
		}
		
		// Insertion
		int[] insArr = al.insertElement(numbers, 4, 33);
		
		// Append
		int[] appArr = al.appendElement(insArr, 66);
		
		// Output
		al.printArray("Original:\t", numbers);
		al.printArray("After Insert:\t", insArr);
		al.printArray("After Append:\t", appArr);
		


	}

}
