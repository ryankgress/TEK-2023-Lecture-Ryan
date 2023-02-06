package com.perscholas.java_basics;

public class OperatorsAndNumbers {

	public static void main(String[] args) {
		/**
		 * 1. Converting decimal to binary
		 * 		0001, 1000, 00100001, 01001110, ...
		 * 2. Converting binary to decimal
		 * 		2, 9, 42, 114, 11,376, ...
		 * 
		 */

//		int x = 2;
//		int x = 9;		// Guess: 1001 > 0001 0010 (18)
//		int x = 17;
//		int x = 88;
		
//		System.out.println(x + " " + Integer.toBinaryString(x));
//		
//		x = x<<1;
//		
//		System.out.println(x + " " + Integer.toBinaryString(x));

		
//		int x = 7;
//		int y = 17;
//		int z = x & y;
//		z = x | y;
//		
//		System.out.println(z);

		int i = 1;
		System.out.println(i);
		i++;
		System.out.println(i);
		
		i += 1;
		System.out.println(i);
		i++;
		System.out.println(i);
		++i;
		System.out.println(i);
		
		int x = 5;
		int y = 8;
//		int sum = ++x + y;
		int sum = x++ + y;
		
		System.out.println("\n" + sum);
		
	}

}
