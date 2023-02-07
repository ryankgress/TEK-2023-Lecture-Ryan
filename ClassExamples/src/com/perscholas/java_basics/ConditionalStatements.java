package com.perscholas.java_basics;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ConditionalStatements {

	public static void main(String[] args) {
		// 1
		int x = 7;
		
		if(x < 10) {
			System.out.println("Less than 10");
		}
		
		// 2
		if(x < 10) {
			System.out.println("Less than 10");
		} else if(x > 10){
			System.out.println("Greater than 10");
		}
		
		// 3
		x = 15;
		
		if(x < 10) {
			System.out.println("Less than 10");
		} else if(x < 20){
			System.out.println("Between 10 and 20");
		} else {
			System.out.println("Greater than or equal to 20");
		}
		
		// 4
		if(x < 10 || x > 20) {
			System.out.println("Out of range");
		} else {
			System.out.println("In range");
		}
		
		// 5
		Scanner keyboard = new Scanner(System.in);
		System.out.print("\n\nPlease enter your score: ");
		
		int score = keyboard.nextInt();
		
		if(score > 100 || score < 0) {
			System.out.println("Score out of range.");
		} else if(score >= 90) {
			System.out.println("A");
		} else if(score >= 80) {
			System.out.println("B");
		}  else if(score >= 70) {
			System.out.println("C");
		}  else if(score >= 60) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}

		
		// 6
		System.out.print("\n\nPlease enter your integer: ");
		int num = keyboard.nextInt();
		
		switch(num) {
			case 1:
				System.out.println("Monday");
				break;
			case 2:
				System.out.println("Tuesday");
				break;
			case 3:
				System.out.println("Wednesday");
				break;
			case 4:
				System.out.println("Thursday");
				break;
			case 5:
				System.out.println("Friday");
				break;
			case 6:
				System.out.println("Saturday");
				break;
			case 7:
				System.out.println("Sunday");
				break;
			default:
				System.out.println("Error. Enter a number between 1 and 7.");
		}
		
		// 7
		
		System.out.print("Filing Status: Single (1), Married Filing Jointly (2), Married Filing Separately (3), Head of Household (4): ");
		int stat = keyboard.nextInt();
		
		System.out.print("Enter your income: ");
		double income = keyboard.nextDouble();
		double tax = 0;
		
		switch (stat) {
			case 1:
				if(income <= 8350) {
					tax = income * .1;
				} else if(income <= 33950) {
					tax = income * .15;
				} else if(income <= 82250) {
					tax = income * .25;
				} else if(income <= 171550) {
					tax = income * .28;
				} else if(income <= 372950) {
					tax = income * .33;
				} else {
					tax = income * .35;
				}
				break;
				
			case 2:
				if(income <= 16700) {
					tax = income * .1;
				} else if(income <= 67900) {
					tax = income * .15;
				} else if(income <= 137050) {
					tax = income * .25;
				} else if(income <= 208850) {
					tax = income * .28;
				} else if(income <= 372950) {
					tax = income * .33;
				} else {
					tax = income * .35;
				}
				break;
				
			case 3:
				if(income <= 8350) {
					tax = income * .1;
				} else if(income <= 33950) {
					tax = income * .15;
				} else if(income <= 68525) {
					tax = income * .25;
				} else if(income <= 104425) {
					tax = income * .28;
				} else if(income <= 186475) {
					tax = income * .33;
				} else {
					tax = income * .35;
				}
				break;
				
			case 4:
				if(income <= 11950) {
					tax = income * .1;
				} else if(income <= 45500) {
					tax = income * .15;
				} else if(income <= 117450) {
					tax = income * .25;
				} else if(income <= 190200) {
					tax = income * .28;
				} else if(income <= 372950) {
					tax = income * .33;
				} else {
					tax = income * .35;
				}
				break;
		}
		
		String pattern = "###,###,###.##";
		DecimalFormat numberFormat = new DecimalFormat(pattern);
		
		System.out.println("Total tax paid for case " + stat + " and an income of $" + numberFormat.format(income) + " is $" + numberFormat.format(tax));
		
		
		
		
		
		
		
		
		
	}

}
