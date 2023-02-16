package com.tek.java.arraylib;

import java.util.Arrays;

public class ArrayLibrary{

	public int[] insertElement(int[] arr, int pos, int num) throws NegativePositionException, PositionTooLargeException {
		
		// Catching errors in position/index
		if(pos < 0) {
			throw new NegativePositionException("Position must be greater than 0");
		} else if(pos > arr.length) {
			throw new PositionTooLargeException("Index is too high");
		}
		
		
		int [] returnArr = appendElement(arr, 0);

		for (int i = pos; i < arr.length; i++) {
			returnArr[i + 1] = arr[i];
		}
		
		returnArr[pos] = num;
		
		return returnArr;
	}
	
	public int[] appendElement(int[] arr, int num) {
		int[] returnArr = new int[arr.length+1];
		
		System.arraycopy(arr, 0, returnArr, 0, arr.length);
		returnArr[arr.length] = num;
		
		return returnArr;
	}
	
	public int[] deleteElement(int[] arr, int inx) {
		int[] returnArr = new int[arr.length-1];
		
		System.arraycopy(arr, 0, returnArr, 0, inx);
		for(int i = inx; i<returnArr.length; i++) {
			returnArr[i] = arr[i+1];
		}
		
		return returnArr;
	}
	
	/**
	 * Find position of passed value. If value is not found, return -1
	 */
	public int findValue(int[] arr, int value) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == value) {
				return i;
			}
		}
		
		return -1;
	}
	
	public int[] bubbleSort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = i; j < arr.length; j++) {
				if(arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}	
		
		return arr;
	}
	
	
	public void printArray(String message, int[] arr) {
		System.out.println(message + " " + Arrays.toString(arr));
	}

}
