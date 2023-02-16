package com.tek.java.arraylib;

public class ALMain {

	public static void main(String[] args) {
		ArrayLibrary al = new ArrayLibrary();
		
		int[] numbers = new int[10];
		
		// Initialize w/ number from 1-10
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = i+1;
		}
		al.printArray("Original:\t", numbers);
		
		// Insertion
		try {
			numbers = al.insertElement(numbers, 30, 33);
			al.printArray("After Insert:\t", numbers);
		} catch (NegativePositionException npe) {
			System.out.println("Negative! " + npe.getMessage());
		} catch (PositionTooLargeException ptle) {
			System.out.println("Too Big! " + ptle.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		// Append
		numbers = al.appendElement(numbers, 66);
		al.printArray("After Append:\t", numbers);
		
		// Delete
		numbers = al.deleteElement(numbers, 4);
		al.printArray("After Delete:\t", numbers);
		
		// Bubble sort
		numbers = al.bubbleSort(numbers);
		al.printArray("After sorting:\t", numbers);
		
		// Output
		
		System.out.println("\nPosition of 6 is " + al.findValue(numbers, 6));


	}

}
