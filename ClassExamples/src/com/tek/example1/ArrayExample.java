package com.tek.example1;

import java.util.Random;

public class ArrayExample {

	public static void main(String[] args) {
		maxRandomValue(1, 500, 10);

	}
	
	public static void maxRandomValue(int smallest, int largest, int length) {
		int[] arr = new int[length];
		Random rand = new Random();
		
		for(int i : arr) {
			arr[i] = rand.nextInt((largest-smallest)+1) + smallest;
			System.out.print(arr[i] + ", ");
		}
		
		
		
	}

}
