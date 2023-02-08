package com.perscholas.java_basics;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysAssignment {

	public static void main(String[] args) {
		// 1 
		int[] nums = new int[3];
		nums[0] = 1; nums[1] = 2; nums[2] = 3;
		
		for(int num : nums) {
			System.out.print(num + " ");
		}

		int[] arr = {13,5,7,68,2};
		System.out.println("\n" + arr[arr.length/2]);
		
		// 2
		String[] colors = {"red", "green", "blue", "yellow"};
		String[] newColors = colors.clone();
		
		for(String col : colors) {
			System.out.print(col + " ");
		}
		System.out.println();
		for(String col : newColors) {
			System.out.print(col + " ");
		}
		
		// 3
		int[] testArr = {1,2,3,4,5};
		System.out.println("\n" + testArr[0] + " " + testArr[testArr.length - 1]);
//		System.out.println(testArr[testArr.length]);
//		testArr[5] = 6;
		
		// 4
		int[] loopArr = new int[5];
		for(int i = 0; i < loopArr.length; i++) {
			loopArr[i] = i;
		}
		
		// 5
		int[] newLoopArr = {3, 6, 9, 12, 15};
		for(int i = 0; i < newLoopArr.length; i++) {
			newLoopArr[i] *= 2;
		}
		
		// 6
		for(int i = 0; i < newLoopArr.length; i++) {
			if(i != 2) {
				System.out.print(newLoopArr[i] + " ");
			}
		}
		
		// 7
		newLoopArr[0] = newLoopArr[2];
		newLoopArr[2] = newLoopArr[0];
		
		// 8
		int[] preSort = {4,2,9,13,1};
		Arrays.sort(preSort);

		System.out.println("\nArray in descending order" + Arrays.toString(preSort));
		System.out.println("Smallest number is " + preSort[0]);
		System.out.println("Largest number is " + preSort[4]);
		System.out.println("\n\n");
		
		// 9 ????
		
		// 10
		faveThings();
		
		
	}
	
	public static void faveThings() {
		Scanner keyboard = new Scanner(System.in);
		int count;
		
		System.out.print("How many favorite things do you have? ");
		count = keyboard.nextInt();
		
		String[] things = new String[count];
		keyboard.nextLine();
		
		for(int i = 0; i < count; i++) {
			System.out.print("Enter your thing: ");
			things[i] = keyboard.nextLine();
		}
		
		System.out.println("Your favorite things are: " + Arrays.toString(things));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
