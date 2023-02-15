package com.tek.java.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortingExamples {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(13);
		arr.add(7);
		arr.add(18);
		arr.add(5);
		arr.add(2);

		System.out.println("Original: " + arr.toString());
		
		// static utility method on Collections object
		Collections.reverse(arr);
		System.out.println("Reverse Ordered: " + arr.toString());
		
		// static utility method on Collections object
		Collections.sort(arr);
		System.out.println("Ordered: " + arr.toString());

		// Uses sort function of ArrayList, passing in a comparator
		// 		Can be used for a custom sort
		arr.sort(Comparator.reverseOrder());
		System.out.println("Comparator reverse: " + arr.toString());
		
		
		
		
	}

}
