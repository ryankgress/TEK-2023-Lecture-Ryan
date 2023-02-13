package com.perscholas.java_basics.polymorphism_assmt;

public class AdultUser implements LibraryUser {
	private int age;
	private String bookType;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	
	@Override
	public void registerAccount() {
		if(this.age >= 12) {
			System.out.println("You have successfully registered under an Adult Account");
		} else {
			System.out.println("Sorry, Age must be over 12 to register as an adult.");
		}
		
	}

	@Override
	public void requestBook() {
		if (bookType.equals("Fiction")) {
			System.out.println("Book issued successfully. Please return within 7 days.");
		} else {
			System.out.println("Oops! You're only allowed to take adult Fiction books.");
		}
		
	}

}
