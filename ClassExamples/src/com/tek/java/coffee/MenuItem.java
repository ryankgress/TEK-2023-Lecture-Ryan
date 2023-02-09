package com.tek.java.coffee;

public class MenuItem {
	
	private String name;
	private double price;
	private int inStock;
	
	// Default Constructor
	public MenuItem() {
		
	}
	
	// Constructor with name & price
	public MenuItem(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public MenuItem(String name, double price, int inStock) {
		this.name = name;
		this.price = price;
		this.inStock = inStock;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getInStock() {
		return inStock;
	}
	public void setInStock(int inStock) {
		this.inStock = inStock;
	}
	
	
	
}
