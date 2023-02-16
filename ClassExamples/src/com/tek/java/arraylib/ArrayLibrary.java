package com.tek.java.arraylib;

import java.util.Arrays;

public class ArrayLibrary {

	public int[] insertElement(int[] arr, int pos, int num) {
		int[] returnArr = new int[arr.length + 1];
		System.arraycopy(arr, 0, returnArr, 0, arr.length);

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
	
	public void printArray(String message, int[] arr) {
		System.out.println(message + " " + Arrays.toString(arr));
	}

}
