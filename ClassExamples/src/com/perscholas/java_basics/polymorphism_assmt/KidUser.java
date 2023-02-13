package com.perscholas.java_basics.polymorphism_assmt;

public class KidUser implements LibraryUser{
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
		if(this.age <= 11) {
			System.out.println("You have successfully registered under a Kids Account");
		} else {
			System.out.println("Sorry, Age must be less than 12 to register as a kid.");
		}
		
	}

	@Override
	public void requestBook() {
		if (bookType.equals("Kids")) {
			System.out.println("Book issued successfully");
		} else {
			System.out.println("Oops! You're only allowed to take kids books.");
		}
		
	}

}
