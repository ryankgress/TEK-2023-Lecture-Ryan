package com.tek.example1;

import java.util.Scanner;

public class FirstClass {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		// Surprising no one, this prints out "Hello World"
		System.out.println("Hello World!");
		
		int i = 5+5;
		System.out.println("5 + 5 = " + i);
		
		System.out.print("Is this math correct? ");
		String ans = keyboard.nextLine();
		
		System.out.println("\n\nYou answered: " + ans);
	}

}
