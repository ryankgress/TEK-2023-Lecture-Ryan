package com.perscholas.java_basics.polymorphism_assmt;

public class LibraryInterfaceDemo {

	public static void main(String[] args) {
		
		// Test Case 1
		KidUser k1 = new KidUser();
		KidUser k2 = new KidUser();

		k1.setAge(10);
		k2.setAge(18);
		
		k1.registerAccount();
		k2.registerAccount();
		
		k1.setBookType("Kids");
		k2.setBookType("Fiction");
		
		k1.requestBook();
		k2.requestBook();
		
		System.out.println("\n");
		
		// Test Case 2
		AdultUser a1 = new AdultUser();
		AdultUser a2 = new AdultUser();

		a1.setAge(5);
		a2.setAge(23);
		
		a1.registerAccount();
		a2.registerAccount();
		
		a1.setBookType("Kids");
		a2.setBookType("Fiction");
		
		a1.requestBook();
		a2.requestBook();
	}

}
