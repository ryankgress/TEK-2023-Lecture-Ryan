package com.perscholas.java_basics;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Loops {

	public static void main(String[] args) {
//		question1();
//		question2();
//		question3();
		

	}
	
	/**
	 * Prints a multiplication table
	 */
	public static void question1 () {
		for(int i = 1; i < 13; i++) {
			for(int j = 1; j < 13; j++) {
				System.out.print(i * j + "\t");
			}
			System.out.println();
		}
	}
	
	/**
	 * Finds GCD of two numbers
	 */
	public static void question2() {
		int n1, n2;
		int gcd = 1;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Number 1: ");
		n1 = keyboard.nextInt();
		System.out.print("Number 2: ");
		n2 = keyboard.nextInt();
		
		for(int i = 1; i <= n1; i++) {
			if(n1 % i == 0) {
				if(n2 % i == 0) {
					gcd = i;
				}
			}
		}
		
		System.out.println("\nThe GCD of " + n1 + " and " + n2 + " is " + gcd);	
	}
	
	/**
	 * Calculates how long to double initial tuition with 7% increase
	 */
	public static void question3() {
		double tuition = 10000;
		final double INCREASE = 1.07;
		int reps = 0;
		
		while(tuition < 20000) {
			tuition *= INCREASE;
			reps ++;
//			System.out.println("reps: " + reps + " \t tuition: " + tuition);
		}
		String pattern = "###,###.##";
		DecimalFormat numberFormat = new DecimalFormat(pattern);
		System.out.println("After " + reps + " years, the tuition will double, reaching $" + numberFormat.format(tuition));
	}

}
















